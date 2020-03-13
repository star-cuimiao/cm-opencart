var app = new Vue({
    el: '#app',
    data: {
		product: [],
		total: 0,
    pageSize: 5,
    productCode: '',
    productName: '',
    price: '',
    stockQuantity: '',
    selectedStatus: '',
    statuses: [
        { value: 0, label: '下架' },
        { value: 1, label: '上架' },
        { value: 2, label: '待审核' }
    ]
    },
   methods: {
    getProduct(pageNum) {
      var search = {
        params:{
          productCode: this.productCode,
          productName: this.productName,
          price: this.price,
          stockQuantity: this.stockQuantity,
          status: this.selectedStatus,
          pageNum:this.pageNum
        }
      }
      axios.get("/product/search",search).then(res => {
        this.product = res.data.list;
        this.total = res.data.total;
        this.pageSize = res.data.pageSize;
      });
    },
    handleSelectionChange(selections){

    },
    currentChange(pageNum){
      this.getProduct(pageNum);
    },
    handleAdd(){
      location.href='product-create.html';
    },
    handleEdit(index,row){
      location.href='product-update.html?productId='+ row.productId;
    }
  },
  mounted() {
    this.getProduct();
  }
 
})
