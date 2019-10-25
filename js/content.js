 	//  评论数
 	var count = 0;
 	// 读取数据库map
 	var m = new Map();

 	// 设置打赏
 	$(document).ready(function () {
 	    $('.mytooltip').tooltipster({
 	        theme: 'tooltipster-shadow',
 	        animation: 'swing ',
 	        trigger: 'click'
 	    });
 	    // 设置顶部平滑滚动
 	    $('.top').click(function () {
 	        $(window).scrollTo(0, 500);
 	    });
 	    // 滚动监测
 	    $('.container').waypoint(function (direction) {
 	        if (direction == 'down') {

 	            $('#pt').show(500);

 	        } else {
 	            $('#pt').hide(400);
 	        }
 	    });

 	    // ----------------评论区
 	    // 获取总的评论数
 	    $('#com').text(count);

 	    $('#isubmit').click(function () {
 	        var name = $('#iname').val();
 	        var content = $('#icontent').val();
 	        var reply = $('#ireply').val();
 	        if (checkName(name) == 0) return;
 	        if (checkContent(content) == 0) return;
 	        openCaret();
 	        $('#com').text(++count);
 	        var list;
 	        if ((list = m.get(name)) == null) {
 	            var ary = new Array();
 	            ary.push({
 	                name: name,
 	                content: content,
 	                reply: reply
 	            });
 	            m.set(name, ary);
 	            $('#body').append(`
						<div class='mt-1 animated bounce' style="font-size:0.9rem;">
							<i class="fa fa-user-o  mr-1"></i>
							<span class="mr-1">` + name + `</span>
							<span class="mr-1  font-italic">发表评论:</span>
						</div>
						<div class="text-muted ml-4">
							<small>` + content + `</small>
						</div>
						`);
 	            $('#body').append(`
						<div id='` + name + `'></div>`);
 	        } else {
 	            list.push({
 	                name: name,
 	                content: content,
 	                reply: reply
 	            });

 	            if (list[list.length - 1].reply == 'true') {
 	                $('#' + name).append(`
							<div class="ml-4 animated bounce" style="font-size:0.9rem;">
								<ul>
									<li>
										<div>
											<span class="mr-1">博主</span>
											<span class="mr-1 font-italic">回复</span>
											<span>` + list[list.length - 1].name + `</span>
										</div>
										<div class="text-muted ml-4">
											<small>` + list[list.length - 1].content + `</small>
										</div>
									</li>
								</ul>
							</div>
							`);
 	            } else {
 	                $('#' + name).append(`
							<div class="ml-4 animated bounce" style="font-size:0.9rem;">
								<ul>
									<li>
										<div>
											<span class="mr-1"> ` + list[list.length - 1].name + `</span>
											<span class="mr-1  font-italic">回复</span>
											<span>博主</span>
										</div>
										<div class="text-muted ml-4">
											<small>` + list[list.length - 1].content + `</small>
										</div>
									</li>
								</ul>
							</div>
							`);
 	            }
 	        }
 	    })
 	});


 	function caretChange() {
 	    if ($('#caret').hasClass('fa-caret-left')) {
 	        $('#caret').removeClass('fa-caret-left');
 	        $('#caret').addClass('fa-caret-down');
 	        $('#body').show();
 	    } else {
 	        $('#caret').removeClass('fa-caret-down');
 	        $('#caret').addClass('fa-caret-left');
 	        $('#body').hide(500);
 	    }
 	}

 	function openCaret() {
 	    $('#body').show(500);
 	    $('#caret').removeClass('fa-caret-left');
 	    $('#caret').addClass('fa-caret-down');
 	}
 	// 校验名称输入,和评论输入
 	function checkName(name) {
 	    if (name == '' || name == null) {
 	        alert('名称不能为空');
 	        return 0;
 	    }
 	    if (name.length > 8) {
 	        alert('名称过长');
 	        return 0;
 	    }
 	}

 	function checkContent(content) {
 	    if (content == '' || content == null) {
 	        alert('内容不能为空');
 	        return 0;
 	    }
 	    if (content.length > 255) {
 	        alert('内容过长');
 	        return 0;
 	    }
 	}