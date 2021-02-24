// 参数说明
/* 
    target 当前节点，需要插入分页内容的节点
    options  输入的参数
*/
function Pagination(target, options) {
    this.target = target
    // 当前页数
    this.currentPage = options.currentPage || 1
    // 总页数
    this.totalPages = options.totalPages || 1
    // 当前页的左右个数
    this.prevCount = options.prevCount || 1
    // 每页显示多少条数据
    this.pageSize = options.pageSize || 10
    // 跳转页面的地址
    this.pageURL = options.pageURL || "javascript:;"
    // 跳转需要传的参数名
    this.param = options.param || ""
    // 当前页标签的class
    this.currContentClass = 'pg-on'
    // 前一页标签的内容
    this.prevContent = '<'
    // 前一页标签的class
    this.prevContentClass = 'pg-prev'
    // 后一页标签的内容
    this.nextContent = '>'
    // 后一页标签class
    this.nextContentClass = 'pg-next'
    // 标签的统一class
    this.allClass = "pg-all"

    this.setPage = function () {
        var html = ''
        // 判断是否首页
        if (this.currentPage > 1) {
            html += '<a href="' + this.pageURL + '?' + this.param + '=' + (this.currentPage - 1) +
                '" class="' + this.prevContentClass + '">' + this.prevContent + '</a>'
            html += '<a href="' + this.pageURL + '?' + this.param + '=' + 1 +
                '" class="' + this.allClass + '">1</a>'
        }
        // 首页时
        else {
            html += '<span class="' + this.prevContentClass + '">' + this.prevContent + '</span>'
            html += '<a href="' + this.pageURL + '?' + this.param + '=' + 1 +
                '" class="' + this.currContentClass + '">1</a>'
        }
        // 判断当前页前面情况
        var start = this.currentPage - this.prevCount
        // 不小于2
        if (start <= 2) {
            for (var j = 2; j < this.currentPage; j++) {
                html += '<a href="' + this.pageURL + '?' + this.param + '=' + j +
                    '" class="' + this.allClass + '">' + j + '</a>'
            }
        }
        else {
            html += '<span>...</span>'
            // 开始缩减到当前页
            for (var j = start; j < this.currentPage; j++) {
                html += '<a href="' + this.pageURL + '?' + this.param + '=' + j +
                    '" class="' + this.allClass + '">' + j + '</a>'
            }
        }
        // 当前页
        if (this.currentPage > 1) {
            console.log(this.currentPage)
            html += '<a href="' + this.pageURL + '?' + this.param + '=' + this.currentPage +
                '" class="' + this.currContentClass + '">' + this.currentPage + '</a>'
        }
        // 判断当前页后面情况
        var end = this.currentPage + this.prevCount
        if (end >= this.totalPages - 1) {
            for (var j = this.currentPage + 1; j < this.totalPages; j++) {
                html += '<a href="' + this.pageURL + '?' + this.param + '=' + j +
                    '" class="' + this.allClass + '">' + j + '</a>'
            }
        }
        else {
            for (var j = this.currentPage + 1; j < end + 1; j++) {
                html += '<a href="' + this.pageURL + '?' + this.param + '=' + j +
                    '" class="' + this.allClass + '">' + j + '</a>'
            }
            html += '<span>...</span>'
        }
        // 末页
        if (this.currentPage == this.totalPages) {
            html += '<span class="' + this.nextContentClass + '">' + this.nextContent + '</span>'
        }
        else {
            html += '<a href="' + this.pageURL + '?' + this.param + '=' + this.totalPages +
                '" class="' + this.allClass + '">' + this.totalPages + '</a>'

            html += '<a href="' + this.pageURL + '?' + this.param + '=' + (this.currentPage + 1) +
                '" class="' + this.nextContentClass + '">' + this.nextContent + '</a>'
        }
        html += '<span class="' + this.allClass + '">共<span>' + this.totalPages + '</span>页，</span>'
        html += '<span class="' + this.allClass + '">到第<input type="text" class="pg-jumpNum" />页</span>'
        html += '<input type="button" value="跳转" class="pg-jumpBtn"/>'
        target.html(html)
    }
    this.setPage()
    return target

}
$.fn.pagination = function (options) {
    return new Pagination(this, options);
}