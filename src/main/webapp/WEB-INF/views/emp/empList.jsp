<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script>
      //작성1: jsp문법이며 server(WAS)에서 해석: ${aa}
      // \${blahblah}: jsp문법 아님, WAS해석 안함.
      //작성2: 백틱문법이며 Browser의 JavaScript 해석기에서해석된다.: `\${aa}`
      let name = "evan"
      let deptlist = [{department_name: "개발부"}, {department_name: "마케팅부"}]
      let testData = `
        \${name}
        ---- 서버해석: ${deptlist[0].department_name}
        ---- 브라우져 해석: \${deptlist[0].department_name}
      `;
      console.log(testData);
    </script>
</head>
<body>
<div class="container">
    <%--include action tag: 각각의 jsp를 따로 컴파일 -> 컴파일 된 class가 이 소스에 들어온다.--%>
    <jsp:include page="../jsp/header.jsp"/>
    <c:set var="path" value="${pageContext.servletContext.contextPath}"/>

    <%--    <jsp:forward page="../jsp/common.jsp"></jsp:forward>--%>
    <hr>
    <button id="btnSalary" class="btn btn-danger">조회(only 급여)</button>
    <button id="btnJob" class="btn btn-success">조회(only 직책)</button>
    <button id="btnDept" class="btn btn-primary">조회(only 부서)</button>
    <button id="btnJobJoin" class="btn btn-warning">조회(only 직책join)</button>
    <button id="btnJobJoin2" class="btn btn-warning">조회(only join-map)</button>
    <button id="btnTransfer" class="btn btn-success">트랜젝션</button>
    <hr>
    <h3>RESTFUL API사용하기</h3>
    <button id="btnSelect" class="btn btn-secondary">전체조회</button>
    <input type="number" id="empid" value="100">
    <button id="btnDetail" class="btn btn-secondary">상세보기</button>
    <button id="btnInsert" class="btn btn-secondary">입력</button>
    <button id="btnUpdate" class="btn btn-secondary">수정</button>
    <button id="btnDelete" class="btn btn-secondary">삭제</button>
    <script>
      $(() => {
        $("#btnSelect").on("click", f_select)
        $("#btnDetail").on("click", f_detail)
        $("#btnInsert").on("click", f_insert)
        $("#btnUpdate").on("click", f_update)
        $("#btnDelete").on("click", f_delete)

        function print(responseData) {
          console.log(responseData);
          let dynamicRows = "";
          $.each(responseData, function (index, emp) {
            dynamicRows += `
                <tr>
                    <td>
                        \${index + 1}
                    </td>
                    <td>
                        <a href='detail.do?empid=\${emp.employee_id}'>\${emp.employee_id}</a>
                    </td>
                    <td>
                        <a href='detail.do?empid=\${emp.employee_id}'>\${emp.first_name}</a>
                    </td>
                    <td>\${emp.last_name}</td>
                    <td>\${emp.email}</td>
                    <td>\${emp.phone_number}</td>
                    <td>\${emp.job_id}</td>
                    <td>
                        \${emp.hire_date}">
                    </td>
                    <td>\${emp.commission_pct}</td>
                    <td>\${emp.salary}</td>
                    <td>\${emp.manager_id}</td>
                    <td>\${emp.department_id}</td>
                </tr>
                `
          })
          let output = `
              <table class="table table-striped color black">
                <tr>
                    <td>순서</td>
                    <td>직원번호</td>
                    <td>fname</td>
                    <td>lname</td>
                    <td>email</td>
                    <td>phone_number</td>
                    <td>job_id</td>
                    <td>hire_date</td>
                    <td>commission</td>
                    <td>salary</td>
                    <td>manager</td>
                    <td>department</td>
                </tr>
                \${dynamicRows}
              </table>
              `;
          return output;
        }

        function f_select() {
          $.ajax({
            url: "${path}/rest/emplist.do",
            success: function (responseData) {
              let output = print(responseData);
              $("#table_here").html(output);
            },
            error: function (err) {
              console.log(err);
            }
          })
        }

        function f_detail() {
          let empid = $("#empid").val();
          $.ajax({
            url: `${path}/rest/empdetail.do/\${empid}`,
            success: function (responseData) {
              let dynamicOutput = "";
              for (let prop in responseData) {
                dynamicOutput += `
                <li>
                  \${prop}의 값은 \${responseData[prop]}
                </li>
                `;
              }

              let output = `
              <ul>
                  \${dynamicOutput}
              </ul>
              `;
              $("#table_here").html(output);
            },
            error: function () {

            }
          })
        }

        function getData() {
          let obj = {
            "employee_id": 748,
            "first_name": "evan",
            "last_name": "Song",
            "email": "evan@naver123.com",
            "phone_number": "010.6682.6308",
            "hire_date": 1732806000000,
            "job_id": "AD_PRES",
            "salary": 24000,
            "commission_pct": 0.8,
            "manager_id": 100,
            "department_id": 90,
          };
          return obj;
        }

        function f_insert() {
          let emp = getData();

          //default contentType form: 'application/x-www-form-urlencoded'
          $.ajax({
            url: `${path}/rest/empinsert.do`,
            type: "post",
            contentType: "application/json",
            data: JSON.stringify(emp),
            success: function (responseData) {
              alert(responseData);
            },
            error: function (err) {
              console.log(err)
            },
          })
        }

        function getUpdateData() {
          let obj = {
            "employee_id": 748,
            "first_name": "evanSong",
            "last_name": "SongJamm",
            "email": "evan@naver987123.com",
            "phone_number": "010.0000.6308",
            "hire_date": 1732806000000,
            "job_id": "AD_PRES",
            "salary": 24000,
            "commission_pct": 0.8,
            "manager_id": 100,
            "department_id": 90,
          };
          return obj;
        }

        function f_update() {
          let emp = getUpdateData();

          $.ajax({
            url: `${path}/rest/empupdate.do`,
            type: "put",
            contentType: "application/json",
            data: JSON.stringify(emp),
            success: function (responseData) {
              alert(responseData);
            },
            error: function (err) {
              console.log(err)
            }
          });
        }

        function f_delete() {
          let empid = $("#empid").val();

          $.ajax({
            url: `${path}/rest/empdelete.do/\${empid}`,
            type: "delete",
            success: function (responseData) {
              alert(responseData);
            },
            error: function (err) {
              console.log(err);
            }
          });
        }
      })
    </script>
    <hr>
    <div class="container mt-4">
        <fieldset class="border p-4 rounded">
            <legend class="w-auto px-2 text-primary">조건선택</legend>
            <span class="input-group-text">부서 아이디</span>
            <select class="form-control" name="department_id">
                <option value="-1">
                    선택안함
                </option>
                <c:forEach items="${deptlist}" var="dept">
                    <option value="${dept.department_id}">
                            ${dept.department_id} / ${dept.department_name}
                    </option>
                </c:forEach>
            </select>
            <span class="input-group-text">jobId</span>
            <select required="required" class="form-control" name="job_id"
                    aria-describedby="basic-addon1">
                <option value="-1">
                    선택안함
                </option>
                <c:forEach items="${joblist}" var="job">
                    <option ${job.job_id == 'IT_PROG' ? 'selected' : ''} value="${job.job_id}">
                            ${job.job_id} / ${job.job_title}
                    </option>
                </c:forEach>
            </select>
            <span class="input-group-text">급여(이상)</span>
            <input type="number" class="form-control" value="5000"
                   name="salary"
                   aria-describedby="basic-addon1">
            <span class="input-group-text">입사일(이후)</span>
            <input type="date" class="form-control"
                   name="hire_date" pattern="yyyy-MM-dd"
                   aria-describedby="basic-addon1">
            <input type="checkbox" name="chkDate" value="1">모든일자
            <button id="btn_condition" class="btn btn-primary">조건조회</button>
        </fieldset>
    </div>
    <h1>직원List</h1>
    <div id="table_here">
    </div>
</div>
<script>
  <%--  여기수정!!!!!!!!!!!!!!!!!!!!!--%>
  $(() => {

    var result = "${resultMessage}"
    if (result != "") {
      alert(result);
    }

    $("#btn_condition").on("click", f_ajax);
    $("#btn_condition").trigger("click");  //이벤트 호출
    $("#btnSalary").on("click", f_salary);
    $("#btnJob").on("click", f_job);
    $("#btnDept").on("click", f_dept);
    $("#btnJobJoin").on("click", f_jobJoin);
    $("#btnJobJoin2").on("click", f_jobJoin2);
    $("#btnTransfer").on("click", f_transfer);

    function f_transfer() {
      $.ajax({
        url: "${path}/emp/transfer.do",
        success: function (responseData) {
          alert(responseData);
        },
        error: function (err) {
          console.log(err)
        },
      })
    }

    function f_salary() {
      $.ajax({
        url: "${path}/emp/listBySalary.do",
        data: {salary: $("input[name='salary']").val()},
        success: function (responseData) {
          $("#table_here").html(responseData);
        },
        error: function (err) {
          console.log(err)
        },
      })
    }

    function f_job() {
      $.ajax({
        url: "${path}/emp/listByJob.do",
        data: {jobid: $("select[name='job_id']").val()},
        success: function (responseData) {
          $("#table_here").html(responseData);
        },
        error: function (err) {
          console.log(err)
        },
      })
    }

    function f_dept() {
      $.ajax({
        url: "${path}/emp/listByDept.do",
        data: {deptid: $("select[name='department_id']").val()},
        success: function (responseData) {
          $("#table_here").html(responseData);
        },
        error: function (err) {
          console.log(err)
        },
      })
    }

    function f_jobJoin() {
      $.ajax({
        url: "${path}/emp/listByJobJoin.do",
        data: {jobid: $("select[name='job_id']").val()},
        success: function (responseData) {
          $("#table_here").html(responseData);
        },
        error: function (err) {
          console.log(err)
        },
      })
    }

    function f_jobJoin2() {
      $.ajax({
        url: "${path}/emp/listByJobJoin2.do",
        data: {jobid: $("select[name='job_id']").val()},
        success: function (responseData) {
          $("#table_here").html(responseData);
        },
        error: function (err) {
          console.log(err)
        },
      })
    }

    function f_ajax() {
      $.ajax({
        url: "${path}/emp/list2.do",
        type: "get",
        data:
          {
            "deptid": $('[name="department_id"]').val(),
            "jobid": $('[name="job_id"]').val(),
            "salary": $('[name="salary"]').val(),
            "hdate": $('[name="hire_date"]').val(),
            "chk": $('[name="chkDate"]').prop('checked')
          },
        success: function (responseData) {
          //2. HTML 만들기 -> NO
          console.log(responseData);
          //3. Servlet에서 JSP를 responseData로 받은 후 현재화면에 replace
          $("#table_here").html(responseData);
        },
        error: function () {
          alert(err);
        },
      });
    }
  });
</script>
</body>
</html>