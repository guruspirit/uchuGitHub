class MusicPlayer {
    private var songs: Array<String> = arrayOf()
    fun add(song: String){
        songs+=song;
    }
    fun show(){
        for(song in songs){
            println(song)
        }
    }
    fun play(){
        println("Playing "+songs.get(0))
    }
}
fun main(args: Array<String>) {
    val m = MusicPlayer()

    while(true) {
        var input = readLine()!!
        if(input == "stop") {
            break
        }
        m.add(input)
    }
    m.show()
    m.play()
}