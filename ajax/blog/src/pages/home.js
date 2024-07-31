async function listBlog(page = 0) {
    const blogs = await getAllBlog(page);
    $('#list-blog').append(renderBlog(blogs));
    renderPagination(blogs);
}

async function searchBlog(page = 0) {
    const blogs = await searchBlogByTitle(page);
    $('#list-blog').html(renderBlog(blogs));
    renderPagination(blogs);
}

async function findBlogByCategory(page = 0) {
    const blogs = await getAllBlogByCategory(page);
    renderBlog(blogs);
    renderPagination(blogs);
}

function renderBlog(blogs) {
    if (!blogs || !Array.isArray(blogs.content) || blogs.content.length === 0) {
        $('#list-blog').html('<h3 class="text-center">Không tìm thấy blog!</h3>');
        return;
    }
    let blog = '';
    blogs.content.forEach(el => {
        blog += `<div class="card-body">
                    <div class="d-flex">
                        <div>
                            <img class="img-fluid rounded-circle overflow-hidden object-fit-cover me-3" src="http://localhost:8080/${el.avatar}"
                            style="width: 75px; height: 75px;">
                        </div>
                        <div class="flex-grow-1">
                            <p class="card-title">${el.author}</p>
                            <a href="/blog/${el.id}/content" class="fw-bold text-dark opacity-75 text-decoration-none">
                            <h5 class="card-text m-0">${el.title}</h5>
                            </a>
                            <p class="card-text"><small class="text-body-secondary">Last updated 3 mins ago</small></p>
                        </div>
                    </div>
                </div>`;
    });
    return blog;

}

function renderPagination(blogs) {
    const paginationControls = $('#pagination-controls');
    if (blogs.last) {
        paginationControls.html("");
        return;
    }
    let pageData = blogs.pageable;
    let pagination = '';
    console.log(pageData);
    if (pageData.pageNumber == 0) {
        if (pageData.pageNumber < pageData.pageSize - 1) {
            pagination += `<button class="btn btn-primary" onclick="listBlog(${pageData.pageNumber + 1})">Xem thêm</button>`;
        } else {
            pagination = '';
        }

    }
    paginationControls.html(pagination);
}


$(document).ready(() => {
    header().then(data => {
        $('#search').click(() => searchBlog(0));
    });
    listBlog();
});