<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<div class="col-lg-3 mb-4">
	<div class="list-group">
		<a href="<%=root%>/modifyForm" class="list-group-item">정보
			수정</a> <a class="list-group-item" data-toggle="modal" href="#deleteModal">회원
			탈퇴</a>
	</div>
</div>
<div class="modal" id="deleteModal">
	<div class="modal-dialog">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">회원 탈퇴</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Modal body -->
			<div class="modal-body">
				<p>다음의 텍스트를 따라 치세요</p>
				<form id="delete" action="" style="display:none"></form>
				<div style="color: red" id="delete-text">계정을 삭제합니다. 삭제된 계정은 복구할 수 없습니다.</div>
				<input type="text" class="form-control" id="delete-input" required>
				<button type="button" class="btn btn-primary" id="btn-delete">계정
					삭제</button>
			</div>

		</div>
	</div>
	<script type="text/javascript">
		$("#btn-delete").on("click", function() {
			console.log("static =>", $("#delete-text").text());
			console.log("input =>", $("#delete-input").val());

			if ($("#delete-text").text() === $("#delete-input").val()) {
				document.getElementById("delete").action = "<%=root%>/delete";
				document.getElementById("delete").method = "post";
				document.getElementById("delete").submit();
			} else {
				alert("입력하신 문자가 경고문과 일치하지 않습니다.");
			}
		});
	</script>
</div>

</html>