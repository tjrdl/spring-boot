<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
    <style>
        .uploadResult{
            width: 100%;
            background-color: gray;
        }
        .uploadResult ul{
            display: flex;
            flex-flow: row;
        }
        .uploadResult ul li{
            list-style: none;
            padding: 10px;
        }
        .uploadResult ul li img{
            width: 20px;
        }
    </style>
	<!-- 	<script src="../resources/js/jquery.js"></script> -->
	<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script type="text/javascript">
		function fn_submit() {
			alert("01");
			var formData = $("#frm").serialize();//form 요소 자체
			alert("02");

			//비동기 전송방식의 jquery 함수
			$.ajax({
				type:"post"
				,data:formData
				,url:"write"
				,success: function(data) {
					alert("저장완료");
					location.href="list";
				}
				,error: function() {
					alert("오류발생");
				}
			});
		}
	</script>
</head>
<body>
<table width="500" border="1">
	<!-- 		<form method="post" action="write"> -->
	<form id="frm" method="post" action="write">
		<tr>
			<td>이름</td>
			<td>
				<input type="text" name="boardName" size="50">
			</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>
				<input type="text" name="boardTitle" size="50">
			</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>
				<textarea rows="10" name="boardContent"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<!-- 					<input type="submit" value="입력"> -->
				<input type="button" onclick="fn_submit()" value="입력">
				&nbsp;&nbsp;
				<a href="list">목록보기</a>
			</td>
		</tr>
	</form>
</table>

File Attach
<div class="uploadDiv">
	<input type="file" name="uploadFile" multiple>
</div>

<div class="uploadResult">
	<ul>

	</ul>
</div>
</body>
</html>
<script>
	$(document).ready(function (e){
        var formObj = $("form[id='frm']");
        $("button[type='submit']").click(function (e){
            e.preventDefault();
            console.log("submit");
            var str="";

            $(".uploadResult ul li").each(function (i, obj) {
               console.log("@# obj=>"+$(obj));
               console.log("@# data=>"+$(obj).data());
               console.log("@# filename>"+$(obj).data("filename"));

               var jobj = $(obj);
               console.log("@# filename2=>"+jobj.data("filename"));
               console.log("@# uuid=>"+jobj.data("uuid"));
               console.log("@# type=>"+jobj.data("type"));
               console.log("@# pathname=>"+jobj.data("path"));

               str +="<input type='hidden' name='attachList["+i+"].fileName' value='"+jobj.data("filename")+"'>";
               str +="<input type='hidden' name='attachList["+i+"].uuid' value='"+jobj.data("uuid")+"'>";
                str +="<input type='hidden' name='attachList["+i+"].uploadPath' value='"+jobj.data("path")+"'>";
                str +="<input type='hidden' name='attachList["+i+"].fileType' value='"+jobj.data("type")+"'>";

            }); //end of uploadResult ul li each
            formObj.append(str).submit();
        }); //end of button submit
		//확장자가 exe|sh|alz 업로드 금지하기 위한 정규식
		var regex = new RegExp("(.*?)\.(exe|sh|alz)$");
		// 파일크기(5MB 미만) 조건
		var maxSize = 5242880;//5MB

		function checkExtension(fileName, fileSize) {
			if(fileSize >= maxSize){
				alert("파일 사이즈 초과");
				return false;
			}
			if (regex.test(fileName)) {
				alert("해당 종류의 파일은 업로드할 수 없습니다.");
				return false;
			}
			return true;
		}

		$("input[type='file']").change(function (e){
			var formData = new FormData();
			var inputFile = $("input[name='uploadFile']");
			//files : 파일정보
			var files = inputFile[0].files;

			for(var i=0; i<files.length; i++){
				console.log("@# files=>"+files[i].name);

				//파일크기와 종류중에서 거짓이면 리턴
				if (!checkExtension(files[i].name, files[i].size)) {
					return false;
				}

				//파일 정보를 formData에 추가
				formData.append("uploadFile",files[i]);
			}

			$.ajax({
				type: "post"
				,data: formData
				,url: "uploadAjaxAction"
//processData : 기본은 key/value 를 Query String 으로 전송하는게 true
//(파일 업로드는 false)
				,processData: false
//contentType : 기본값 : "application / x-www-form-urlencoded; charset = UTF-8"
//첨부파일은 false : multipart/form-data로 전송됨
				,contentType: false
				,success: function (result) {
					alert("Uploaded");
					console.log(result);
					//파일정보들을 함수로 보냄
					showUploadResult(result);//업로드 결과 처리 함수
				}
			});//end of ajax

			function showUploadResult(uploadResultArr) {
				if (!uploadResultArr || uploadResultArr.length == 0) {
					return;
				}

				var uploadUL = $(".uploadResult ul");
				var str="";

				$(uploadResultArr).each(function (i, obj) {
					//image type
					if (obj.image) {
						console.log("@# obj.uploadPath=>"+obj.uploadPath);
						console.log("@# obj.uuid=>"+obj.uuid);
						console.log("@# obj.fileName=>"+obj.fileName);

						var fileCallPath = obj.uploadPath +"/s_"+ obj.uuid + "_" + obj.fileName;
						str += "<li><div>";
						str += "<span>"+obj.fileName+"</span>";
						str += "<img src='/display?fileName="+fileCallPath+"'>";
						str += "<span data-file=\'"+fileCallPath+"\'data-type='image'>x</span>";
						str += "</div></li>";
					} else {
						// var fileCallPath = encodeURIComponent(obj.uploadPath +"/"+ obj.uuid + "_" + obj.fileName);
						var fileCallPath = obj.uploadPath +"/"+ obj.uuid + "_" + obj.fileName;
						str += "<li><div>";
						str += "<span>"+obj.fileName+"</span>";
						str += "<img src='/img/attach.png'>";
						str += "<span data-file=\'"+fileCallPath+"\'data-type='file'>x</span>";
						str += "</div></li>";
					}
				});//end of each

				uploadUL.append(str);

				$(".uploadResult").on("click", "span", function() {
    var $this = $(this);
    var targetFile = $this.data("file");
    var type = $this.data("type");
    var uploadResultItem = $this.closest("li");

    if (!confirm("파일을 삭제하시겠습니까?")) {
        return;
    }

    $.ajax({
        type: "POST",
        url: "/deleteFile",  // 올바른 URL로 수정
        data: {
            fileName: targetFile,
            type: type
        },
        success: function(response) {
            if (response === "deleted") {
                alert("파일이 성공적으로 삭제되었습니다.");
                uploadResultItem.remove();
            } else {
                alert("파일 삭제에 실패했습니다.");
            }
        },
        error: function(xhr, status, error) {
            console.error("에러 상세정보:", xhr.responseText);
            alert("파일 삭제 중 오류가 발생했습니다.");
        }
    });
});
			}
		});//end of change
	});//end of ready
</script>