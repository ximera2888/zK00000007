import org.junit.Test

import org.junit.Assert.*

class wallServiceTest {

    @Test
    fun addPost() {
        var post=Post(1,0)
        post=wallService.addPost(post)
        assertNotEquals(0,post.id)
    }

    @Test
    fun updatePostTrue() {
        var post=Post(1,0)
        wallService.addPost(post)
        wallService.addPost(post)
        post=Post(2,5)
        assertEquals(true,wallService.updatePost(post))
    }

    @Test
    fun updatePostFalse() {
        var post=Post(1,0)
        wallService.addPost(post)
        wallService.addPost(post)
        post=Post(8,5)
        assertEquals(false,wallService.updatePost(post))
    }
    @Test(expected = PostNotFoundException::class)
    fun createCommentException() {
        var comment=wallService.createComment(-1,"Привет, Котлин")?:throw PostNotFoundException("post not found")
    }
    @Test
    fun createComment() {
        var post = Post(1, 0)
        wallService.addPost(post)
        var comment=wallService.createComment(1,"Привет, Котлин")?:throw PostNotFoundException("post not found")
        assertEquals(comment.text,"Привет, Котлин")
    }
}