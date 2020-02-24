
# Product
| 字段 | 类型 | 说明 |
|----|----|----|
| product_id  | int  | 商品Id  |
| product_code | varchar(50)  | 商品代码  |
| product_name | varchar(100)  | 商品名称  |
| product_abstract | varchar(100)  | 摘要  |
| price  | double  | 价格  |
| discount  | double  | 打折（0.01-0.99）  |
| sort_order  | int  | 排序  |
| stock_quantity  | int  | 库存数量  |
| status  | tinyint  | 状态（0下架、1上架、2待审核）  |
| reword_points  | int  | 积分  |
| main_pic_url | varchar(100)  | 主图  |



## 1.1查询商品列表
URL: /product/search?product_name={product_name}&product_code={product_code}&price={price}&quantity={quantity}&status={status}
Method:GET

ResponseBody:
```json
{
    "pageSize":"5",
    "pageName":"1",
    "total":"10",
    "list":[
        {
            "product_name":"苹果手机",
            "product_code":"xMax",
            "price":6800,
            "stock_quantity":500,
            "status":1,
            "main_pic_url":"pingguo.png"
        },
        {
            "product_name":"小米手机",
            "product_code":"xMax",
            "price":3800,
            "stock_quantity":200,
            "status":1,
            "main_pic_url":"xiaomi.png"
        }
    ]
}
   
```

Request Field  

| 字段    |   类型 |   描述   | 
|---|---|---|
| pageNum  | int  |  当前页数  |
| product_name | varchar(100)  | 商品名称  |
| product_code | varchar(50)  |  商品代码  |
| price  | double  | 价格  |
| quantity  | int  |  库存数量  |
| status  | tinyint  |  状态（0下架、1上架、2待审核）  |


Response Field  

| 字段  | 类型  |  说明 |
|---|---|---|---|
| product_code | varchar(20) | 商品编号 |
| product_name | varchar(20) | 商品名称 |
| price | double | 商品价格 |
| stock_quantity | int(100) | 库存量 |
| status | tinyint | 状态(0未上架,1已上架,2已下架,3已售空) |
| main_pic_url | varchar(20) | 主图 |
| total | int | 页码总数 |
| pageSize | int | 当前页条数 |


## 1.2创建商品
URL: /product/create
Method:POST

RequestBody:
```json
    {
        "product_name":"苹果手机",
        "product_code":"xMax",
        "price":6800,
        "stock_quantity":500,
        "status":1,
        "main_pic_url":"pingguo.png"
    }
```

Request Field  

| 字段    |   类型 |   描述   | 
|---|---|---|
| product_name | varchar(100)  | 商品名称  |
| product_code | varchar(50)  |  商品代码  |
| price  | double  | 价格  |
| quantity  | int  |  库存数量  |
| status  | tinyint  |  状态（0下架、1上架、2待审核）  | 

## 1.3商品回显
URL: /product/selectById?product_id={product_id}
Method:GET

ResponseBody:
```json
   {
            "product_id":1,
            "product_name":"苹果手机",
            "product_code":"xMax",
            "price":6800,
            "stock_quantity":500,
            "status":1,
            "main_pic_url":"pingguo.png"
        }
}
   
```

Request Field  

| 字段    |   类型 |   描述   | 
|---|---|---|
| product_id  | int  |  商品id  |


Response Field  

| 字段  | 类型  |  说明 |
|---|---|---|---|
| product_code | varchar(20) | 商品编号 |
| product_name | varchar(20) | 商品名称 |
| price | double | 商品价格 |
| stock_quantity | int(100) | 库存量 |
| status | tinyint | 状态(0未上架,1已上架,2已下架,3已售空) |
| main_pic_url | varchar(20) | 主图 |


## 1.4编辑商品
URL: /product/update
Method:POST

RequestBody:
```json
    {
        "product_id":1,
        "product_name":"苹果手机",
        "product_code":"xMax",
        "price":6800,
        "stock_quantity":500,
        "status":1,
        "main_pic_url":"pingguo.png"
    }
```

Request Field  

| 字段    |   类型 |   描述   | 
|---|---|---|
| product_id | int(11)  | 商品id  |
| product_name | varchar(100)  | 商品名称  |
| product_code | varchar(50)  |  商品代码  |
| price  | double  | 价格  |
| quantity  | int  |  库存数量  |
| status  | tinyint  |  状态（0下架、1上架、2待审核）  | 


## 1.5删除商品
URL: /product/deleteById?product_id={product_id}
Method:POST

RequestBody:
```json
    52
```

Request Field  

| 字段    |   类型 |   描述   | 
|---|---|---|
| product_id | varchar(100)  | 商品id  |





# Order
| 字段 | 类型 | 说明 |
|----|----|----|
| order_id  | bigint  | Id  |
| customer_id | int  | 客户Id  |
| status | tinyint  | 非空 | 订单状态（0待处理、1处理中、2待发货、3已发货、4待签收、5已签收、6待支付、7已支付、8取消、9拒绝、10完成）  |
| total_price  | double  | 总价  |
| pay_method | smallint  | 支付方式  |
| ship_method  | smallint  | 寄送方式  |
| reword_points  | int  | 订单积分  |
| create_time  | datetime  | 创建时间  |
| update_time  | datetime  | 更新时间 |

## 2.1查询订单列表
URL: /order/search?order_id={order_id}&customer_name={customer_name}
Method:GET

ResponseBody:
```json
{
    "pageSize":5,
    "pageName":1,
    "total":10,
    "list":[
        {
            "order_id":4,
            "customer_name":"崔淼",
            "status":2,
            "total_price":8888,
            "create_time":"2020-02-23",
            "update_time":"2020-02-23",
        },
        {
            "order_id":7,
            "customer_name":"范闲",
            "status":2,
            "total_price":6888,
            "create_time":"2020-02-23",
            "update_time":"2020-02-23",
        }
    ]
}
```

Request Field  

| 字段 | 类型 | 说明 |
|----|----|----|
| pageNum | int | 当前页 | 
| order_id | int(11) | 订单id | 
| customer_name | int(11) | 客户名 |

Response Field  

| 字段 | 类型 | 说明 |
|----|----|----|
| order_id | int(11) | 订单id | 
| customer_id | int(11) | 客户id |
| status | tinyint | 订单状态（0待处理、1处理中、2待发货、3已发货、4待签收、5已签收、6待支付、7已支付、8取消、9拒绝、10完成） |
| total_price | double | 总金额 |
| create_time | datetime | 创建时间 |
| update_time | datetime | 修改时间 |
| total | int | 总条数 |
| pageSize| int | 每页条数 |


## 2.2创建订单
URL: /order/create
Method:POST

RequestBody:
```json
    {
        "customer_id":2,
        "status":2,
        "total_price":8888,
        "create_time":"2020-02-23",
        "update_time":"2020-02-23",
    }
```

Request Field  

| 字段 | 类型 | 说明 |
|----|----|----|
| customer_id | int(11) | 客户id |
| status | tinyint | 订单状态（0待处理、1处理中、2待发货、3已发货、4待签收、5已签收、6待支付、7已支付、8取消、9拒绝、10完成）|
| total_price | double | 总金额 |
| create_time | datetime | 创建时间 |
| update_time | datetime | 修改时间 |

## 2.3修改订单
URL: /order/update
Method:POST

RequestBody:
```json
    {
        "order_id":4,
        "customer_id":3,
        "status":2,
        "total_price":8888,
        "create_time":"2020-02-23",
        "update_time":"2020-02-23",
    }
```

Request Field  

| 字段 | 类型 | 说明 |
|----|----|----|
| order_id | int(11) | 订单id | 
| customer_id | int(11) | 客户id |
| status | tinyint | 订单状态(0待处理、1处理中、2待发货、3已发货、4待签收、5已签收、6待支付、7已支付、8取消、9拒绝、10完成)|
| total_price | double | 总金额 |
| create_time | datetime | 创建时间 |
| update_time | datetime | 修改时间 |

## 2.4删除订单
URL: /order/deleteById?order_id={order_id}
Method:POST

RequestBody:
```json

        44

```

Request Field  

| 字段 | 类型 | 说明 |
|----|----|----|
| order_id | int(11) | 订单id | 


# OrderHistory
| 字段  | 类型  | 约束  |  说明 |
|---|---|---|---|
| order_history_id  | bigint  | 主键 自增 | Id  |
| order_id | int  | 非空，索引，外键 | 订单Id  |
| time | datetime  | 非空 | 时间  |
| order_status  | tinyint  | 非空 | 订单状态  |
| comment  | varchar(300)  |  | 备注  |
| customer_notified  | bit  | 非空  | 是否通知客户  |


## 3.1查询订单历史列表
URL: /orderhistory/search?order_id={order_id}&customer_name={customer_name}?&status={status}
Method:GET

ResponseBody:
```json
{
    "pageSize":5,
    "pageName":1,
    "total":10,
    "list":[
        {
            "order_id":4,
            "customer_name":"崔淼",
            "order_status":2,
            "total_price":8888,
            "time":"2020-02-23",
        },
        {
            "order_id":7,
            "customer_name":"范闲",
            "order_status":2,
            "total_price":6888,
            "time":"2020-02-23",
        }
    ]
}
```

Request Field  

| 字段 | 类型 | 说明 |
|----|----|----|
| pageNum | int  | 当前页  |
| order_id | int  | 订单Id  |
| order_status  | tinyint  | 订单状态  |

Response Field  

| 字段 | 类型 | 说明 |
|----|----|----|
| order_history_id  | bigint  | 主键 自增 | Id  |
| order_id | int  | 非空，索引，外键 | 订单Id  |
| time | datetime  | 非空 | 时间  |
| order_status  | tinyint  | 非空 | 订单状态  |

## 3.2创建订单历史
URL: /orderhistory/create
Method:POST

ResponseBody:
```json
  {
    "order_id":4,
    "order_status":2,
    "time":"2020-02-23",
    "comment":"退货尽量要快点哦!",
    "customer_notified":true
 }
```

Request Field  

| 字段 | 类型 | 说明 |
|----|----|----|
| order_id | int  | 非空，索引，外键 | 订单Id  |
| time | datetime  | 非空 | 时间  |
| order_status  | tinyint  | 非空 | 订单状态  |
| comment  | varchar(300)  |  | 备注  |
| customer_notified  | bit  | 非空  | 是否通知客户  |

## 2.3修改订单历史
URL: /orderhistory/create
Method:POST

ResponseBody:
```json
  {
    "order_history_id":1,
    "order_id":3,
    "order_status":1,
    "time":"2020-02-23",
    "comment":"快点退货!",
    "customer_notified":true
 }
```

Request Field  

| 字段 | 类型 | 说明 |
|----|----|----|
| order_history_id | int  | 订单历史Id  |
| order_id | int  | 订单Id  |
| time | datetime  | 时间  |
| order_status  | tinyint  | 订单状态  |
| comment  | varchar(300)  | 备注  |
| customer_notified  | bit  | 是否通知客户  |


## 3.4.删除订单历史
URL: /orderhistory/deleteById?order_history_id={order_history_id}
Method:POST

ResponseBody:
```json
    25
```

Request Field  

| 字段 | 类型 | 说明 |
|----|----|----|
| order_history_id | int  | 订单历史Id |


# Return
| 字段  | 类型  |  说明 |
|---|---|---|---|
| return_id  | int  | 退货Id  |
| order_id | int  | 订单Id  |
| order_time | datetime  |  | 订单时间  |
| customer_name  | varchar(20)  | 退货人  |
| mobile  | varchar(20)  | 手机  |
| email  | varchar(100)  | 邮箱  |
| status  | tinyint  | 状态（0等待取货、1正在处理、完成）  |
| return_action | tinyint  | 处理方式（0退货、1换货、2修理）  |
| product_code  | varchar(50)  | 商品代码  |
| product_name  | varchar(100)  | 商品名称  |
| quantity  | int  | 商品数量  |
| reason  | tinyint  | 退货原因  |
| opened  | bit  | 是否开封  |
| comment  | varchar(300) | 备注  |
| create_time  | datetime  | 创建时间  |
| update_time  | datetime  | 修改时间  |



## 4.1查询退货列表
URL: /return/search?return_id={return_id}&order_id={order_id}&customer_name={customer_name}&product_name={product_name}&status={status}
Method:GET

ResponseBody:
```json
{
    "pageSize":5,
    "pageName":1,
    "total":10,
    "list":[
        {
            "return_id":4,
            "order_id":2,
            "customer_name":"崔淼",
            "product_name":"苹果XSmax",
            "status":2,
            "create_time":"2020-02-23",
            "update_time":"2020-02-23",
        },
        {
            "return_id":7,
            "order_id":6,
            "customer_name":"范闲",
            "product_name":"小米",
            "status":2,
            "create_time":"2020-02-23",
            "update_time":"2020-02-23",
        }
    ]
}
```

Request Field  

| 字段 | 类型 | 说明 |
|----|----|----|
| pageNum  | int  | 当前页  |
| return_id  | int  | 退货Id  |
| order_id | int  | 订单Id  |
| customer_name  | varchar(20)  | 退货人  |
| status  | tinyint  | 状态（0等待取货、1正在处理、完成）  |
| product_name  | varchar(100)  | 商品名称  |

Response Field  

| 字段 | 类型 | 说明 |
|----|----|----|
| return_id  | int  | 退货Id  |
| order_id | int  | 订单Id  |
| customer_name  | varchar(20)  | 退货人  |
| status  | tinyint  | 状态（0等待取货、1正在处理、完成）  |
| product_name  | varchar(100)  | 商品名称  |
| create_time  | datetime  | 创建时间  |
| update_time  | datetime  | 修改时间  |


## 4.2创建退货
URL: /return/create
Method:POST

ResponseBody:
```json
    {
        "order_id":2,
        "customer_id":4,
        "product_code":"s68",
        "product_name":"苹果XSmax",
        "mobile":"15938601218",
        "email":"1969617856@qq.com",
        "status":2,
        "return_action":0,
        "quantity":1,
        "reason":3,
        "opened":false,
        "comment":"不想要了",
        "create_time":"2020-02-23",
    }
```

Request Field  

| 字段 | 类型 | 说明 |
|----|----|----|
| order_id | int  | 订单Id  |
| order_time | datetime  |  | 订单时间  |
| customer_name  | varchar(20)  | 退货人  |
| mobile  | varchar(20)  | 手机  |
| email  | varchar(100)  | 邮箱  |
| status  | tinyint  | 状态（0等待取货、1正在处理、完成）  |
| return_action | tinyint  | 处理方式（0退货、1换货、2修理）  |
| product_code  | varchar(50)  | 商品代码  |
| product_name  | varchar(100)  | 商品名称  |
| quantity  | int  | 商品数量  |
| reason  | tinyint  | 退货原因  |
| opened  | bit  | 是否开封  |
| comment  | varchar(300) | 备注  |
| create_time  | datetime  | 创建时间  |
| update_time  | datetime  | 修改时间  |


## 4.3修改退货
URL: /return/update
Method:POST

ResponseBody:
```json
    {
        "return_id":4,
        "order_id":3,
        "customer_id":5,
        "product_code":"888",
        "product_name":"IphoneX",
        "mobile":"1969617856",
        "email":"1969617856@qq.com",
        "status":2,
        "return_action":0,
        "quantity":1,
        "reason":3,
        "opened":true,
        "comment":"不小心下错单了",
        "update_time":"2020-02-23",
    }
```

Request Field  

| 字段 | 类型 | 说明 |
|----|----|----|
| return_id | int  | 退货Id  |
| order_id | int  | 订单Id  |
| order_time | datetime  |  | 订单时间  |
| customer_name  | varchar(20)  | 退货人  |
| mobile  | varchar(20)  | 手机  |
| email  | varchar(100)  | 邮箱  |
| status  | tinyint  | 状态（0等待取货、1正在处理、完成）  |
| return_action | tinyint  | 处理方式（0退货、1换货、2修理）  |
| product_code  | varchar(50)  | 商品代码  |
| product_name  | varchar(100)  | 商品名称  |
| quantity  | int  | 商品数量  |
| reason  | tinyint  | 退货原因  |
| opened  | bit  | 是否开封  |
| comment  | varchar(300) | 备注  |
| update_time  | datetime  | 修改时间  |


## 4.4删除退货
URL: /return/create
Method:POST

ResponseBody:
```json

    520
```

Request Field  

| 字段 | 类型 | 说明 |
|----|----|----|
| return_id | int  | 退货Id  |


# Customer
| 字段 | 类型 | 说明 |
|----|----|----|----|
| customer_id | int(11) | 客户id | 
| username | varchar(20) | 用户名 |
| mobile | varchar(20) | 手机 |
| mobile_verified | varchar(20) | 手机验证 |
| email | varchar(20) | 邮箱 |
| email_verified | varchar(20) | 邮箱验证 |
| real_name | varchar(20) | 姓名 |
| status | tinyint| 状态(0,禁用,1启用) |
| default_address_id | int(11) | 默认地址id |
| encrpted_password | varchar(100) | 加密密码 |
| news_subscribed | bit | 新闻订阅 |
| create_time | datetime | 创建时间 |



## 5.1查询客户列表
URL: /cusomer/search?cusomer_name={cusomer_name}&status={status}&create_time={create_time}
Method:GET

ResponseBody:
```json
{
    "pageSize":5,
    "pageName":1,
    "total":10,
    "list":[
        {
            "cusomer_name":"崔崔崔淼",
            "email":"17891956247@qq.com",
            "status":1,
            "create_time":"2018-06-06",
        },
        {
            "cusomer_name":"崔淼",
            "email":"1969617856@qq.com",
            "status":1,
            "create_time":"2019-02-22",
        }
    ]
}
```

Request Field  

| 字段 | 类型 | 说明 |
|----|----|----|
| pageNum | int | 当前页 |
| username | varchar(20) | 用户名 |
| status | tinyint| 状态(0,禁用,1启用) |



Response Field  

| 字段 | 类型 | 说明 |
|----|----|----|
| customer_id | int(11) | 客户id | 
| username | varchar(20) | 用户名 |
| email | varchar(20) | 邮箱 |
| status | tinyint| 状态(0,禁用,1启用) |



## 5.2创建客户
URL: /cusomer/create
Method:POST

ResponseBody:
```json
{
    "cusomer_name":"崔崔崔淼",
    "mobile":"17891956274",
    "mobile_verified":"0921",
    "email":"17891956247@qq.com",
    "email_verified":"9577",
    "real_name":"崔淼",
    "status":1,
    "default_address_id":1,
    "news_subscribed":true,
    "encrpted_password":"03117599",
    "create_time":"2018-06-06",
}

```

Request Field  

| 字段 | 类型 | 说明 |
|----|----|----|
| username | varchar(20) | 用户名 |
| mobile | varchar(20) | 手机 |
| mobile_verified | varchar(20) | 手机验证 |
| email | varchar(20) | 邮箱 |
| email_verified | varchar(20) | 邮箱验证 |
| real_name | varchar(20) | 姓名 |
| status | tinyint| 状态(0,禁用,1启用) |
| default_address_id | int(11) | 默认地址id |
| encrpted_password | varchar(100) | 加密密码 |
| news_subscribed | bit | 新闻订阅 |
| create_time | datetime | 创建时间 |


## 5.3修改客户
URL: /cusomer/update
Method:POST

ResponseBody:
```json
{
    "customer_id":4,
    "cusomer_name":"崔崔崔淼",
    "mobile":"17891956274",
    "mobile_verified":"0921",
    "email":"17891956247@qq.com",
    "email_verified":"9577",
    "real_name":"崔淼",
    "status":1,
    "default_address_id":1,
    "news_subscribed":true,
    "encrpted_password":"03117599",
    "create_time":"2018-06-06",
}

```

Request Field  

| 字段 | 类型 | 说明 |
|----|----|----|
| customer_id | int(11) | 用户id |
| username | varchar(20) | 用户名 |
| mobile | varchar(20) | 手机 |
| mobile_verified | varchar(20) | 手机验证 |
| email | varchar(20) | 邮箱 |
| email_verified | varchar(20) | 邮箱验证 |
| real_name | varchar(20) | 姓名 |
| status | tinyint| 状态(0,禁用,1启用) |
| default_address_id | int(11) | 默认地址id |
| encrpted_password | varchar(100) | 加密密码 |
| news_subscribed | bit | 新闻订阅 |
| create_time | datetime | 创建时间 |


## 5.4删除客户
URL: /cusomer/deleteById?customer_id={customer_id}
Method:POST

ResponseBody:
```json
    42
}

```

Request Field  

| 字段 | 类型 | 说明 |
|----|----|----|
| customer_id | int(11) | 客户id |


# Address
| 字段 | 类型 | 说明 |
|----|----|----|
| address_id | int(11) | 地址id | 
| customer_id | int(11) | 客户id |
| receiver_names | varchar(20) | 收货人姓名 |
| receiver_mobile | varchar(20) | 收货人手机 |
| content | varchar(100) | 地址内容 |


## 6.1查询地址列表
URL: /address/search?receiver_names={receiver_names}&receiver_mobile={receiver_mobile}
Method:GET

ResponseBody:
```json
{
    "pageSize":5,
    "pageName":1,
    "total":10,
    "list":
    [

    {
        "receiver_names":"崔淼",
        "receiver_mobile":"17891956247",
        "content":"河南省周口市郸城县"
    },
    {
        "receiver_names":"大大怪将军",
        "receiver_mobile":"15938601218",
        "content":"上海市奉贤区"
    }
]
}

```

Request Field  

| 字段 | 类型 | 说明 |
|----|----|----|
| pageNum | int | 当前页 |
| receiver_names | varchar(20) | 收货人姓名 |
| receiver_mobile | varchar(20) | 收货人手机 |

Response Field  

| 字段 | 类型 | 说明 |
|----|----|----|----|
| address_id | int(11) | 地址id | 
| customer_id | int(11) |客户id |
| receiver_names | varchar(20) |收货人姓名 |
| receiver_mobile | varchar(20) |收货人手机 |
| content | varchar(100) |地址内容 |
| total | int |总条数 |
| pageSize | int |每页展示条数 |


## 6.2.创建地址
URL: /address/create
Method:POST

RequestBody:
```json
    {
        "customer_id":1,
        "receiver_names":"崔淼",
        "receiver_mobile":"17891956247",
        "content":"河南省周口市郸城县"
    }
```

Request Field  

| 字段 |  类型 |  描述   | 
|----|----|----|
| customer_id | int(11) |客户id |
| receiver_names | varchar(20) |收货人姓名 |
| receiver_mobile | varchar(20) |收货人手机 |
| content | varchar(100) |地址内容 |


## 6.3.修改地址
URL: /address/update
Method:POST

RequestBody:
```json
    {
        "address_id":1,
        "customer_id":1,
        "receiver_names":"崔淼",
        "receiver_mobile":"17891956247",
        "content":"河南省周口市郸城县"
    }
```

Request Field  

| 字段 |  类型 |  描述   | 
|----|----|----|
| address_id | int(11) | 地址id | 
| customer_id | int(11)| 客户id |
| receiver_names | varchar(20)  |收货人姓名 |
| receiver_mobile | varchar(20) |收货人手机 |
| content | varchar(100) | 地址内容 |


## 6.4删除地址
URL: /address/deleteById?address_id={address_id}
Method:POST

RequestBody:
```json
    2
```

Request Field  

| 字段    |   类型 |   描述   | 
|---|---|---|
| address_id | int(11)  | 地址id  |




# Administrator
| 字段  | 类型  |  说明 |
|---|---|---|
| administrator_id  | int  | Id  |
| username | varchar(20)  | 用户名  |
| real_name  | varchar(20)  | 真实姓名  |
| email  | varchar(20)  | 邮箱 |
| encrypted_password  | varchar(100)  | 加密密码  |
| status  | tinyint  | 状态（0禁用，1启用）  |
| create_time  | datetime   | 创建时间  |
| avatar_url  | varchar(100)  | 头像地址 |


## 7.1查询管理员列表
URL: administrator/search?username={username}&status={status}&create_time={create_time}
Method:GET

ResponseBody:
```json
{
    "pageSize":5,
    "pageName":1,
    "total":10,
    "list":
    [

    {
        "username":"弥彦",
        "status":1,
        "create_time":"2019-12-23"
    },
    {
        "username":"长门",
        "status":1,
        "create_time":"2020-01-17"
    }
]
}

```

Request Field  

| 字段 | 类型 | 说明 |
|----|----|----|
| pageNum | int | 当前页 |
| username | varchar(20)  | 用户名  |
| status  | tinyint  | 状态（0禁用，1启用）  |
| create_time  | datetime   | 创建时间  |


Response Field  

| 字段 | 类型 | 说明 |
|----|----|----|----|
| username | varchar(20)  | 用户名  |
| status  | tinyint  | 状态（0禁用，1启用）  |
| create_time  | datetime   | 创建时间  |
| total | int |总条数 |
| pageSize | int |每页展示条数 |



## 7.21创建管理员
URL: administrator/create
Method:POST

ResponseBody:
```json
{
     "username":"小南",
     "real_name":"张无忌",
     "email":"1969617856@qq.com",
     "encrypted_password":"qwertskdl455sdsad",
     "status":1,
     "create_time":"2020-01-17",
     "avatar_url":"555456448.png"
}

```

Request Field  

| 字段 | 类型 | 说明 |
|----|----|----|
| username | varchar(20)  | 用户名  |
| real_name  | varchar(20)  | 真实姓名  |
| email  | varchar(20)  | 邮箱 |
| encrypted_password  | varchar(100)  | 加密密码  |
| status  | tinyint  | 状态（0禁用，1启用）  |
| create_time  | datetime   | 创建时间  |
| avatar_url  | varchar(100)  | 头像地址 |



## 7.3修改管理员
URL: administrator/update
Method:POST

ResponseBody:
```json
{
    
     "administrator_id":4,
     "username":"宇智波佐助",
     "real_name":"张楚岚",
     "email":"1969617856@qq.com",
     "encrypted_password":"01759955dlsafda",
     "status":1,
     "create_time":"2020-01-17",
     "avatar_url":"zcl.png"
}

```

Request Field  

| 字段 | 类型 | 说明 |
|----|----|----|
| administrator_id  | int  | Id  |
| username | varchar(20)  | 用户名  |
| real_name  | varchar(20)  | 真实姓名  |
| email  | varchar(20)  | 邮箱 |
| encrypted_password  | varchar(100)  | 加密密码  |
| status  | tinyint  | 状态（0禁用，1启用）  |
| create_time  | datetime   | 创建时间  |
| avatar_url  | varchar(100)  | 头像地址 |


## 7.4删除管理员
URL: administrator/deleteById={administrator_id}
Method:POST

ResponseBody:
```json
    12
```

Request Field  

| 字段 | 类型 | 说明 |
|----|----|----|
| administrator_id | int | 管理员id |







