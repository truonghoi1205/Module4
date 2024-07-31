//hiển thị list student
let p = 2;
function showListStudent(page = 0) {
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "GET",
        url: "http://localhost:8080/api/students?page=" + page,
        success: function (data) {
            let dataTable = "";
            $.each(data.content, function (index, el) {
                dataTable += `    
                             <tr>
                                <td>${index+1}</td>
                                <td>${el.name}</td>
                                <td>${el.age}</td>
                                <td>${el.classroom.name}</td>
                                <td>${el.address}</td>
                                <td>
                                    <button class="btn btn-sm btn-outline-success" id="edit">Sửa</button>
                                    <button class="btn btn-sm btn-outline-danger" id="delete">Xoá</button>
                                </td>
                             </tr>   
                           `
            })
            $('#tbody').html(dataTable)

            if (data.last) {
                $('#load-more').prop("disabled", true).fadeOut("slow")
            }
            $('#load-more').click(function () {
                p += 2;
                showListStudent(p)
            });
        }
    })
}

//chạy for lấy được danh sách student
// function showTableListStudent() {
//     $('#list-student').html(`<div class="d-flex justify-content-between">
//                                     <h2 class="m-0">Danh sách học sinh</h2>
//                                     <button class="btn btn-sm btn-outline-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop" id="add-student">Thêm học sinh</button>
//                                 </div>
//                                <table class="table table-bordered table-hover mt-3">
//                                     <thead>
//                                        <tr>
//                                            <th>STT</th>
//                                            <th>Tên</th>
//                                            <th>Tuổi</th>
//                                            <th>Lớp</th>
//                                            <th>Địa chỉ</th>
//                                            <th></th>
//                                        </tr>
//                                    </thead>
//                                    <tbody id="tbody"></tbody>
//                                </table>
//                                 <div class="text-center">
//                                 <button class="btn btn-sm  btn-primary" id="load-more">Xem thêm</button>
//                                 </div>`);
//
// }

showListStudent(p);

$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/classrooms",
        success: function (data) {
            let option = `<select name="classroom" id="classroom" class="form-select">`;
            $.each(data.content, function (index, el) {
                option += `<option value="${el.id}">${el.name}</option>`
            })
            option += `</select>`
            $('#select-class').html(option);
        }
    })
});


//Thêm mới học sinh
function createStudent() {
    let name = $('#name').val();
    let age = $('#age').val();
    let address = $('#address').val();
    let classroom = $('#classroom').val();

    let newStudent = {
        name,
        age,
        address,
        classroom: {
            id: classroom
        }
    }

    $.ajax({
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },

        type: "POST",
        data: JSON.stringify(newStudent),
        url: "http://localhost:8080/api/students",
        success: function () {
            showAlert('Thêm thành công', 'message')
            $('#staticBackdrop .btn-close').click()
            showListStudent(p)
        },
        error: function () {
            showAlert('Thêm thất bại', 'message')
        }
    })

}

const showAlert = (massage, type, text) => {
    Swal.fire({
        icon: type,
        title: massage,
        text: text
    })
}