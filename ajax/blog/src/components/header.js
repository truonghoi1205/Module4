async function header() {
    const categories = await getAllCategory();

    let category = "";   
    categories.forEach(el => {
        category += `<li><a id=category_id class="dropdown-item" href="blog/category?categoryId=${el.id}">${el.name}</a></li>`
    });

    return (`
<nav class="navbar navbar-expand-lg">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">BLOG CÁ NHÂN</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/blog">Trang chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="/admin/blog">Trang quản lí blog</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="http://localhost:8080/admin/categories">Trang quản lí danh mục</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="/blog" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        Danh mục
                    </a>
                    <ul class="dropdown-menu">
                       ${category}
                    </ul>
                </li>
            </ul>
                <input id="keyword" class="form-control me-2 w-25" type="search" name="keyword"
                       placeholder="Nhập nội dung" aria-label="Search">
                <button class="btn btn-sm btn-outline-success" id="search" type="button">Tìm</button>
        </div>
    </div>
</nav>
        `)
}

header().then(data => {
    $('body').prepend(data);
    $('#search').click(searchBlog);
    $('#category_id').click(findBlogByCategory);
})

