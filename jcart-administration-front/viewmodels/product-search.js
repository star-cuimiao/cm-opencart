var app = new Vue({
    el: '#app',
    data: {
		product: [],
		total: 0,
    pageSize: 5,
    },
   methods: {
    getProduct(pageNum) {
      var search = {
        params:{
          pageNum:pageNum
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
       this.$router.push("/product-create")
    },
    handleEdit(index,row){
      this.$router.push({name: "ProductUpdate",params:row})
    }
  },
  mounted() {
    this.getProduct();
  }
 
})
