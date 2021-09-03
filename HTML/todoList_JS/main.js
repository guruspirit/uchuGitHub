const addTaskBtn = document.getElementById('add-task-btn');
const deskTaskInput = document.getElementById('description-task');
const todosWrapper = document.querySelector('.todos-wrapper');

let tasks;
!localStorage.tasks ? tasks = [] : tasks = JSON.parse(localStorage.getItem('tasks'));

let todoItemsElems = [];

function Task(description){
    this.description = description;
    this.completed = false;
}



const createTemplate = (task,index) => {
    return `
        <div class="todo-item ${task.completed ? 'checked' : ''}">
            <div class="description">${task.description}</div>
            <div class="buttons">
                <input onClick="completeTask(${index})" class="btn-complete" type="checkbox" ${task.completed ? 'checked' : ""}>
                <button onClick="deleteTask(${index})" class="btn-delete">Delete</button>
            </div>
        </div>
            
        `
}

const filterTasks = () => {
    const activeTasks = tasks.length && tasks.filter(item => item.completed == false);
    const completedTasks = tasks.length && tasks.filter(item => item.completed == true);
    tasks = [...activeTasks,...completedTasks];

}

const fillHtmlList = () => {
    
    todosWrapper.innerHTML=""; // очистка HTML
    if(tasks.length > 0){
        filterTasks();
        tasks.forEach((item, index) => {
            todosWrapper.innerHTML += createTemplate(item,index);
        });
    }
    todoItemsElems = document.querySelectorAll('.todo-item');
}

fillHtmlList();

const completeTask = index => {
    tasks[index].completed=!tasks[index].completed;
    if(tasks[index].completed){
        todoItemsElems[index].classList.add('checked');
    } else {
        todoItemsElems[index].classList.remove('checked');
    }
    updateLocal();
    fillHtmlList();

}

const updateLocal = () => {
    localStorage.setItem('tasks',JSON.stringify(tasks));
}

addTaskBtn.addEventListener('click', () =>{
    tasks.push(new Task(deskTaskInput.value));
    updateLocal();
    //console.log(tasks);
    fillHtmlList();
    deskTaskInput.value='';
});

let deleteTask = index => {
    todoItemsElems[index].classList.add('deletion');
    setTimeout(() => {
        tasks.splice(index,1);
        updateLocal();
        fillHtmlList();
    }, 800);
}