<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">

	if (window.name == "update") {
		window.opener.parent.location.href = "board?command=board_update_form&num=${param.num}";
	} else if (window.name == "delete") {
		window.opener.parent.location.href = "board?command=board_delete&num=${param.num}";
	}
	//창 꺼주기
	window.close();
</script>
