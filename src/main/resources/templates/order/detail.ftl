<html>
<head>
    <meta charset="utf-8">
    <title>卖家订单详情</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span4">
            <table class="table">
                <thead>
                <tr>
                    <th>订单ID</th>
                    <th>订单总金额</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${orderDTO.orderId}</td>
                    <td>${orderDTO.orderAmount}</td>
                </tr>
                </tbody>
            </table>
        </div>

        <div class="span12">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>商品ID</th>
                    <th>商品名称</th>
                    <th>价格</th>
                    <th>数量 </th>
                    <th>总额 </th>
                </tr>
                </thead>
                <tbody>
                <#list orderDTO.orderDetailList as orderDetail>
                <tr>
                    <td>${orderDetail.productId}</td>
                    <td>${orderDetail.productName}</td>
                    <td>${orderDetail.productPrice}</td>
                    <td>${orderDetail.productQuantity}</td>
                    <td>${orderDetail.productQuantity * orderDetail.productPrice}</td>
                </tr>
                </#list>

                </tbody>
            </table>
        </div>

        <div class="row-fluid">

        <#--操作-->
        <#if orderDTO.getOrderStatusEnum().message== "新订单">
            <div class="span12">
                <a href="/sell/order/finish?orderId=${orderDTO.orderId}" class="btn btn-success" type="button">完结订单</a>
                <a href="/sell/order/cancel?orderId=${orderDTO.orderId}" class="btn btn-danger" type="button">取消订单</a>
            </div>
        </#if>
        </div>
    </div>
</div>

</body>
</html>