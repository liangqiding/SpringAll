new Vue({
    el: "#test",
    data: {
        //列表
        product_codeList: {},
    },
    created: function () {

        this.findAll();

    },
    methods: {

        findAll: function () {
            var _this = this;
            axios.get('/getProduct_codeList', {
                params: {
                    id: 0
                }
            })
                .then(function (value) {
                    _this.product_codeList = value.data;
                    console.log(value);
                })
                .catch(function (error) {
                    console.log(error);
                })

        },
    }
})


// vue1.findAll(66)

