const getAllBlog = (page) => {
    return $.ajax({
         headers: {
             'Accept': 'application/json',
             'Content-Type': 'application/json'
         },
         type:"GET",
        url: `http://localhost:8080/api/blog?page=${page}`
     })
 } 
 
const searchBlogByTitle = () => {
    let keyword = $('#keyword').val();

    return $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type:"GET",
        url: `http://localhost:8080/api/blog/search?keyword=${keyword}`,
    })
}

const getAllBlogByCategory = () => {
    return $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type:"GET",
        url: `http://localhost:8080/api/blog/category?categoryId=${categoryId}`
    })
}