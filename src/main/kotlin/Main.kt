import java.lang.RuntimeException

class PostNotFoundException(message:String):RuntimeException(message)
data class Post(
    val id: Int,
    val likes: Int,
    val owner_id: Int = 1,
    val fromId: Int = 2,
    val created_by: Int = 2,
    val date: Int = 2,
    val text: String = "Hallo, kotlin",
    val attachments: Array  <Attachment> = emptyArray(),
    val friends_only: Boolean ?=false,
    val can_delete: Boolean?=true
) {}
//data class attachmentPost():Array

//class Photo(override var id: Int = 1, override override val type: String): AttachmentPhoto
object likes {
    fun addLikes(post: Post): Post {
        val likeAdd = post.copy(likes = post.likes + 1)
        return likeAdd
    }
}
data class commentPost(val id: Int, val postId:Int, val text: String )
object wallService {
    var posts = emptyArray<Post>()
    private var idLast: Int = 0

    var comments= emptyArray<commentPost>()
    private var idLastComment: Int = 0
    fun addPost(post: Post): Post {
        idLast = idLast + 1
        posts += post.copy(id = idLast)
        return posts.last()
    }

    fun updatePost(postUp: Post): Boolean {
        var update: Boolean = false
        for ((index, post) in posts.withIndex()) {
            if (post.id == postUp.id) {
                posts[index] = postUp.copy()
                update = true
            }
        }
        return update
    }

fun createComment(postId:Int, text: String):commentPost?{
    for ((index, post) in posts.withIndex()) {
        if (post.id == postId) {
            idLastComment++
           val comment=commentPost(idLastComment,postId,text)
            comments+=comment
            return comment
        }
    }
    return null
}
    fun postsCount(): Int {
        return posts.size
    }
    fun commentsCount(): Int {
        return comments.size
    }
    fun postsLastId(): Int {
        return posts.last().id
    }

}

fun main(args: Array<String>) {
    var post = Post(1, 0, attachments = emptyArray())

    println(post)
    post = likes.addLikes(post)
    println(post)

    //проверка addPost
    wallService.addPost(post)
    println("Количество= " + wallService.postsCount())
    println("Последний id " + wallService.postsLastId())
    wallService.addPost(post)
    println("Количество= " + wallService.postsCount())
    println("Последний id " + wallService.postsLastId())

    //проверка update
    post = Post(2, 5, attachments = emptyArray())
    println("обновление поста= " + wallService.updatePost(post))

    //Проверка комментариев
    var comment=wallService.createComment(1,"Привет, Котлин")?:throw PostNotFoundException("post not found")
    println("добавлен комментарий= " + wallService.commentsCount())

}