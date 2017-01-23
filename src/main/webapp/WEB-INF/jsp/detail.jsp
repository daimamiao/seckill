<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <title>秒杀详情页</title>
    <%@include file="common/head.jsp" %>
</head>
<body>
    <div class="container">
        <div class="panel panel-default text-center">
            <div class="panel-heading">
                <h1>${seckill.name}</h1>
            </div>
            <div class="panel-body">
                <h2 class="text-danger">
                    <span class="glyphicon glyphicon-time"></span>

                    <span class="glyphicon" id="seckill-box"></span>
                </h2>
            </div>
        </div>
    </div>

    <div id="killPhoneModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <div class="modal-title text-center">
                        <span class="glyphicon glyphicon-phone">秒杀电话</span>
                    </div>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-xs-8 col-xs-offset-2">
                            <input type="text" class="form-control" id="killPhoneKey" name="killPhone" placeholder="请填写手机号">
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <span id="killPhoneMessage" class="glyphicon"></span>
                    <button class="btn btn-success" id="killPhoneBtn">
                    <span class="glyphicon glyphicon-phone">
                        Submit
                    </span>
                    </button>
                </div>
            </div>
        </div>
    </div>
</body>
<%@include file="common/footer.jsp" %>
<script src="https://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script src="https://cdn.bootcss.com/jquery.countdown/2.0.2/jquery.countdown.min.js"></script>
<script src="/resources/js/seckill.js" type="text/javascript"></script>
<script type="text/javascript">
    $(function () {
        // 使用EL表达式传入参数
        seckill.detail.init({
            seckillId : ${seckill.seckillId},
            startTime : ${seckill.startTime.time},
            endTime : ${seckill.endTime.time}
        });
    });
</script>
</html>
