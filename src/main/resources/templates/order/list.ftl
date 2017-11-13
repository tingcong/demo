<html>
<head>
    <meta charset="utf-8">
    <title>卖家商品列表</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-bordered table-hover table-condensed">
                <thead>
                <tr>
                    <th>订单ID</th>
                    <th>姓名</th>
                    <th>手机号</th>
                    <th>地址</th>
                    <th>金额</th>
                    <th>订单状态</th>
                    <th>支付状态</th>
                    <th>创建时间</th>
                    <th colspan="2">操作</th>
                </tr>
                </thead>
                <tbody>
                <#list orderDTOPage.content as orderDTO>
                <tr>
                    <td>${orderDTO.orderId}</td>
                    <td>${orderDTO.buyerName}</td>
                    <td>${orderDTO.buyerPhone}</td>
                    <td>${orderDTO.buyerAddress}</td>
                    <td>${orderDTO.orderAmount}</td>
                    <td>${orderDTO.getOrderStatusEnum().getMessage()}</td>
                    <td>${orderDTO.getPayStatusEnum().message}</td>
                    <td>${orderDTO.createTime}</td>
                    <td>
                        <a href="/sell/order/detail?orderId=${orderDTO.orderId}">详情</a>
                    </td>
                    <td>
                        <#if orderDTO.getOrderStatusEnum().message != "已取消">
                            <a href="/sell/order/cancel?orderId=${orderDTO.orderId}">取消</a>
                        </#if>

                    </td>
                </tr>
                </#list>
                </tbody>
            </table>
        <#--分页-->
            <div class="col-md-12 column">
                <ul class="pagination pull-right">
                <#if currentPage lte 1>
                    <li class="disabled">
                        <a href="">上一页</a>
                    </li>
                <#else >
                    <li>
                        <a href="/sell/order/list?page=${currentPage - 1}&size=${size}">上一页</a>
                    </li>
                </#if>
                <#list 1..orderDTOPage.getTotalPages() as index>
                    <#if currentPage == index>
                        <li class="disabled">
                            <a href="">${index}</a>
                        </li>
                    <#else >
                        <li>
                            <a href="/sell/order/list?page=${index}&size=${size}">${index}</a>
                        </li>
                    </#if>
                </#list>
                <#if currentPage gte orderDTOPage.getTotalPages()>
                    <li class="disabled">
                        <a href="">下一页</a>
                    </li>
                <#else>
                    <li class="disabled">
                        <a href="/sell/order/list?page=${currentPage+1}&size=${size}">下一页</a>
                    </li>
                </#if>
                </ul>
            </div>
        </div>
    </div>
</div>
<script>
    var websocket=null;
    if('WebSocket' in window){
        websocket=new WebSocket('ws://localhost:9090/sell/webSocket');
    }else {
        alert("浏览器不支持websocket");
    }
    websocket.onopen=function (event) {
        console.log('建立连接');
    }
    websocket.onclose=function (event) {
        console.log('关闭连接');
    }
    websocket.onmessage=function (event) {
        console.log('收到消息:'+event.data);
        //消息提醒
    }
    websocket.onerror=function (event) {
        alert('websocket通讯发生错误');
    }
    window.onbeforeunload=function () {
        websocket.close();
    }
</script>
</body>
</html>
