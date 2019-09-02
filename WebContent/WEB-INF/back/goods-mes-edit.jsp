<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="http://g.alicdn.com/bui/bui/1.1.21/css/bs3/dpl.css" rel="stylesheet">
    <link href="http://g.alicdn.com/bui/bui/1.1.21/css/bs3/bui.css" rel="stylesheet">
    <link rel="stylesheet" href="css/index.css">
    <!--<link rel="stylesheet" href="css/goods-add.css">-->
    <link rel="stylesheet" href="font/iconfont.css">
</head>
<script src="js/jquery.min.js"></script>
<body>
<div class="doc-content">
    <ul class="breadcrumb breadcrumb2"></ul>
    <ul class="breadcrumb">
        <li>
            <span class="iconfont icon-shouye"></span>
            <a href="#">首页</a> <span class="divider"><span class="iconfont icon-down-trangle1"></span></span>
        </li>
        <li class="active">商品新增</li>
    </ul>
    <div class="tit">
        <span class="iconfont icon-guanlianniu"></span>
        <span>商品新增</span>
        <span class="iconfont icon-down-trangle2"></span>
    </div>
    <ul class="nav-tabs" id="tit">
        <li class="active"><a href="#">基本信息</a></li>
        <li><a href="#">商品参数</a></li>
        <li><a href="#">商品规格</a></li>
        <li><a href="#">商品图片</a></li>
    </ul>
    <div class="content conn" >
        <div class="row roww ">
            <div class="span20 doc-content">
                <form class="form-horizontal well gd">
                    <div class="row">
                        <div class="control-group span9">
                            <label class="control-label"><s>*</s>商品分类：</label>
                            <div class="controls">
                                <select style="width:205px;padding-left: 60px">
                                    <option>请选择</option>
                                    <option>养生类</option>
                                    <option>茶叶</option>
                                </select>
                            </div>
                        </div>
                        <div class="control-group span9">
                            <label class="control-label"><s>*</s>供应商：</label>
                            <div class="controls">
                                <select style="width:205px;padding-left: 60px">
                                    <option>请选择</option>
                                    <option>供应商1</option>
                                    <option>供应商2</option>
                                </select>
                            </div>
                        </div>
                        <div class="control-group span9">
                            <label class="control-label"><s>*</s>商品名称：</label>
                            <div class="controls">
                                <input type="text" class="control-text">
                            </div>
                        </div>
                        <div class="control-group span9">
                            <label class="control-label"><s>*</s>商品编码：</label>
                            <div class="controls">
                                <input type="text" class="control-text">
                            </div>
                        </div>
                        <div class="control-group span9">
                            <label class="control-label"><s>*</s>零售价格：</label>
                            <div class="controls">
                                <input type="text" class="control-text">
                            </div>
                        </div>
                        <div class="control-group span9">
                            <label class="control-label"><s>*</s>库存量：</label>
                            <div class="controls">
                                <input type="text" class="control-text">
                            </div>
                        </div>
                        <div class="control-group span9">
                            <label class="control-label"><s>*</s>成本价格：</label>
                            <div class="controls">
                                <input type="text" class="control-text">
                            </div>
                        </div>
                        <div class="control-group span20">
                            <label class="control-label">商品简介：</label>
                            <div class="controls">
                                <input type="text" class="control-text">
                            </div>
                        </div>
                        <div class="control-group span22">
                            <label class="control-label">商品详情：</label>
                            <div class="controls">
                                <textarea type="text"></textarea>
                            </div>
                        </div>
                        <div class="control-group span23">
                            <label class="control-label">折扣率：</label>
                            <div class="controls">
                                <input type="text" class="control-text">
                            </div>
                        </div>
                        <div class="control-group span23">
                            <label class="control-label">额外运费：</label>
                            <div class="controls">
                                <input type="text" class="control-text">
                            </div>
                        </div>
                        <div class="control-group span8">
                            <label class="radio">
                                是否启用：
                                <input type="checkbox">是
                            </label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-actions offset3">
                            <button type="submit" class="button button-primary">下一步</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div class="row roww dis-none">
            <form class="span95">
                <table cellspacing="0" class="table table-head-bordered table-bordered table-sm">
                    <thead>
                    <tr style="">
                        <th>商品参数名称</th>
                        <th>商品参数值</th>
                        <th>排序</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>
                            储藏方式
                        </td>
                        <td>冰箱灵冷冻室冷冻</td>
                        <td>1</td>
                        <td><a href="#" class="edit">编辑</a> <a href="#">删除</a></td>
                    </tr>
                    <tr>
                        <td>
                            储藏方式2
                        </td>
                        <td>冰箱灵冷冻室冷冻2</td>
                        <td>2</td>
                        <td><a href="#" class="edit">编辑</a> <a href="#">删除</a></td>
                    </tr>
                    </tbody>
                </table>


                <div class="row  edit-r">
                    <h4>添加新的商品参数:</h4>
                    <div class="control-group span18">
                        <label class="control-label">商品参数名称：</label>
                        <input type="text" class="control-text">
                    </div>
                    <div class="control-group span18">
                        <label class="control-label">商品参数值：</label>
                        <input type="text" class="control-text">
                    </div>
                </div>
                <div class="row edit-c">
                    <h4>商品信息编辑:</h4>
                    <div class="control-group span18">
                        <label class="control-label">商品参数名称：</label>
                        <input type="text" class="control-text edit-name">
                    </div>
                    <div class="control-group span18">
                        <label class="control-label">商品参数值：</label>
                        <input type="text" class="control-text edit-zhi">
                    </div>
                    <div class="control-group span18">
                        <label class="control-label">排序：</label>
                        <input type="text" class="control-text edit-pai" readonly style="text-align: center">
                    </div>
                </div>
                <div class="btn btn-c">
                    <span>保存</span>
                </div>
            </form>

        </div>
        <div class="row roww dis-none">
            <div class="btn bb s-btn" id="sbtn" style="margin-left: 20px;margin-top: 0;margin-bottom: 10px;">
                <span>添加规格</span>
            </div>
            <form class="span95">
                <table cellspacing="0" class="table table-head-bordered table-bordered table-sm">
                    <thead>
                    <tr style="">
                        <th>
                            <label class="control-label checkbox">
                                <input type="checkbox">
                            </label>
                        </th>
                        <th>规格</th>
                        <th>规格值</th>
                        <th>创建时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>
                            <label class="control-label checkbox">
                                <input type="checkbox">
                            </label>
                        </td>
                        <td>颜色</td>
                        <td> 白色 &nbsp;蓝色 &nbsp;黑色 &nbsp;棕色 &nbsp;褐色 &nbsp;</td>
                        <td>2017-01-04 10：13：55</td>
                        <td><a href="#">编辑</a></td>
                    </tr>
                    <tr>
                        <td>
                            <label class="control-label checkbox">
                                <input type="checkbox">
                            </label>
                        </td>
                        <td>尺寸</td>
                        <td> M &nbsp;L &nbsp;XL &nbsp;XXS &nbsp;XS &nbsp;S</td>
                        <td>2017-01-04 10：13：55</td>
                        <td><a href="#">编辑</a></td>
                    </tr>
                    <tr>
                        <td>
                            <label class="control-label checkbox">
                                <input type="checkbox">
                            </label>
                        </td>
                        <td>尺码</td>
                        <td> 37 &nbsp;38 &nbsp;39 &nbsp;40 &nbsp;41 &nbsp;42</td>
                        <td>2017-01-04 10：13：55</td>
                        <td><a href="#">编辑</a></td>
                    </tr>
                    </tbody>
                </table>
                <h4>添加新的商品规格:</h4>

                <div class="row">
                    <div class="control-group span18">
                        <label class="control-label">规格名称：</label>
                        <input type="text" class="control-text">
                    </div>
                    <div class="control-group span18">
                        <label class="control-label">规格值：</label>
                        <input type="text" class="control-text">
                    </div>
                </div>

                <div class="btn">
                    <span>保存</span>
                </div>
            </form>

        </div>
        <div class="row roww dis-none">
            <form class="span95">
                <table cellspacing="0" class="table table-head-bordered table-bordered table-sm">
                    <thead>
                    <tr style="">
                        <th>图片</th>
                        <th>排序</th>
                        <th>标题</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>
                            <img src="img/ig2.png" alt="">
                        </td>
                        <td>1</td>
                        <td>gteshgt</td>
                        <td><a href="#">编辑</a> <a href="#">删除</a></td>
                    </tr>
                    </tbody>
                </table>
                <h4>添加新的图片:</h4>

                <div class="control-group control-group1 sh1">
                    <label class="control-label"><s>*</s>图片：</label>
                    <img src="img/ig.png" id="yushow" class="sh2"/>
                </div>
                <input type="text" id="file"  value="上传一个文件">
                <input type="file" class="jtt"  onclick="" style="background: #880000;opacity: 0">
                <div class="row">
                    <div class="control-group">
                        <label class="control-label">标题：</label>
                        <input type="text"  name="goods-dis" class="control-text">
                    </div>
                </div>
                <div class="row">
                    <div class="control-group span18">
                        <label class="control-label">显示顺序：</label>
                        <select>
                            <option>0</option>
                            <option>1</option>
                            <option>2</option>
                        </select>
                    </div>
                </div>

                <div class="btn">
                    <span>保存</span>
                </div>
            </form>

        </div>
    </div>


</div>
</body>
<script>
    $(document).ready(function () {
        $('#tit li').each(function(index){
            $(this).click(function(){
                $('#tit li').removeClass('active');
                $(this).addClass('active')
                $('.conn .roww').each(function(ind){
                    if(ind!=index){
                        $(this).addClass('dis-none')
                    }
                });
                $('.conn .roww').eq(index).removeClass('dis-none');
            })
        })

        $('.edit').each(function(ind){
            $(this).click(function(){
                $('.edit-r').eq(ind).css({display:'none'});
                $('.edit-c').eq(ind).css({display:'block'});
                console.log($(this).eq(0).context.parentNode.parentNode.childNodes[1].innerText)
                $('.edit-name').val($(this).eq(0).context.parentNode.parentNode.childNodes[1].innerText);
                $('.edit-zhi').val($(this).eq(0).context.parentNode.parentNode.childNodes[3].innerText);
                $('.edit-pai').val($(this).eq(0).context.parentNode.parentNode.childNodes[5].innerText);
            })
        })

        $('.btn-c').each(function(ind){
            $(this).click(function(){
                $('.edit-c').eq(ind).css({display:'none'});
                $('.edit-r').eq(ind).css({display:'block'});
            })
        })

//        加图

        let imgarr=['jpeg','png','gif'];
        let size=10*1024*1024;
        console.log($('.jt'))
        $('.jtt').get(0).onchange=function (e){
            var that=this;
            console.dir(this)
            var read=new FileReader();
            read.readAsDataURL(this.files[0]);
            console.log($('.sh2').get(0).src)
            read.onload=function () {
                $('.sh2').get(0).src=this.result;
            }
        }



    })

</script>
</html>