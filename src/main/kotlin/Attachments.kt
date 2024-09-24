interface Attachment {
    val id:Int
    val type:String
    val title:String
}
data class Photo(val id: Int, val album_id:Int=0, val owner_id:Int)
data class Video(val id: Int,val owner_id:Int, val duration:Int )
data class Audio(val id: Int, val owner_id:Int, val artist:String="Noname",val album_id:Int=0)
data class File(val id: Int,  val owner_id:Int, val title: String, val size:Int)
data class Url(val url: String, val title: String,val caption: String,)
class AttachmentPhoto(override var id:Int, override val type:String="Photo", override val title:String, val photo:Photo ):Attachment{

}
class AttachmentVideo(override var id:Int, override val type:String="Video", override val title:String,val video:Video  ):Attachment{

}
class AttachmentAudio(override var id:Int, override val type:String="Audio", override val title:String,val audio:Audio ):Attachment{

}
class AttachmentFile(override var id:Int, override val type:String="File", override val title:String,val file:File ):Attachment{

}
class AttachmentUrl(override var id:Int, override val type:String="Url", override val title:String ,val url:Url):Attachment{

}
