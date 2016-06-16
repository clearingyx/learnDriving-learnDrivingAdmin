写在最前——
	请在使用本SSM框架前仔细阅读本文档，若使用过程中遇到不明白的地方，也可以会看具体说明。
结构：
src
|--com.net
	|--common
		|--handlers 此处应存放不属于实体关联相关业务的URL映射类，如：@RequestMapping("index")、
					@RequestMapping("main")、@RequestMapping("error")等并不是平台关联业务的
					映射集合，集中放到此包下，handler的名称为CommonController。
		|--WeChatConfig.java 微信公众号配置类，若没有微信业务，忽略此类即可；若处理公众号业务，请更
							   换对应配置
	|--crud			此包下的类结果为一一对应，既为了符合代码规范，也是为了协同合作，除了问题，方便寻
					找排错，提高工作效率
		|--dao		此包下存放所有的实体类对应dao；如：UserDao
		|--handlers	此包下存放所有实体类对应的handler；如UserController
		|--modal	此包下存放所有实体类本身；如：User
		|--service	暂时未创建此包，若有需要，涉及到事物操作，建议单独将所有的业务封装到对应的service
					中并将封装好的业务类存放到此包下；如如UserService
	|--demo			此包下所有类均为演示功能实现，通过各种方式实现可能会用到的方法，原理相同。若有需要，
					请参考相关方法，结合自己具体业务实现。各类和各方法都有明确注释，请仔细阅读，并亲自
					尝试。
	|--exceptions	此处为以后业务需要定义自定义Exception留准备，自定义异常均放到此包下，
					如：StockOutException-库存不足异常
		|--handlers	此包下为MyExceptionHandler自定义异常处理，平台所有异常不管在调用出
					是否处理，均要抛出异常，统一在此处会有处理。
	|--intercpter	此包为过滤器，对登录身份验证，URL过滤的配置，具体看MyInterceptor中的注释及方法
	|--resolver		此包为ckeditor图片上传reqeust的自定义转换器，为了解决Multipart http被spring
					消耗的问题
	|--util			此包下为集成的工具类，提供了字符串，json序列化，反序列化等工具类方法，删除文件等
					方法，请视情况自行查看，在test包下有其对应的调用方法。需特殊说明：发送短信工具类
					已集成SendMsg_webchinese.java，激光推送JPushClientUtil.java。
	|--weixin.handlers	绑定微信公众号是必须集成或在此类中写处理业务，调用的是开源框架fastweixin框架，
						使用版本为1.2.8，github地址：https://github.com/sd4324530/fastweixin
resource	平台所有配置信息均存放于此，便于管理
	|--mybatis
		|--common	公共的Mapper.xml映射文件存放，如果需要。
		|--system	包名可自行更换，此处存放所有DAO对应的mapper映射文件，如：UserMapper.xml
	|--config.properties	系统平台公共配置信息，如domain-域名，极光推送的key和secret等。
	|--dbconfig.properties	数据库连接配置，此系统采用阿里的DRUID框架，感兴趣可以找相关资料了解。
	|--log4j.properties		日志系统格式配置，如果现有日志无法满足你的要求，可在此处修改。
	|--springmvc.xml		系统配置，包含数据库，初始化mybatis等信息。
test
	|--com.net.test	此系统推荐使用junit单元测试自己的代码，测试通过，表明代码层无错误，可考虑是
					否为web请求等相关出错。且此处代码均为测试平台现有功能代码，可参考如何调用工
					具类的相应方法。
=====================================分隔线=============================================
以下介绍webroot的目录结构，跟目录为webroot
webroot
	|--META-INF	系统自检，请无视，若使用版本不同的myeclipse在操作svn提交时，此目录可不用提交，以免
				发生不必要的异常
	|--WEB-INF	推荐搞一个公共页面，common.jsp，此页面将所有的js、css和plugins引入页面，然后jsp页
				面中直接<%@ include file="../Common.jsp"%>导入
		|--css	系统所用到所有css文件均需要存放到此处，且在不论在HTML或者jsp中引入时，均应该这样引入
				<link href="css/*.css" rel="stylesheet" type="text/css" />，因为css在springmvc.xml
				中已经做过静态文件映射。框架除外，如layer或者ckeditor等，框架需要保留原始文件结构，不需要
				手动将其文件结构破坏，将css放入此目录。
		|--images 系统所需要用到的图片均存放到此处（非上传图片），系统原有图片，如css样式中引用的图片等。
				  同样所有的图片静态资源也做了映射，在页面中引入，<img src="images/xx.png"/>。同样框架除外。
		|--js	系统所需素有js文件，除框架意外，均存放此目录下。且，同样的文件尽可能只保留一个版本，页面中也值引
				入一个文件，比如jQuery。尽量不要选太旧的版本，比如1.7.1。使用新版本时如果要兼容旧版本功能，可以
				引入jquery-migrate-1.1.0.min.js 来做兼容。页面引入多个jQuery可能因为版本冲突而引起不必要的错误。
				引入方式：<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
		|--plugins	所有集成的第三方插件均存放于此文件夹下，如ckeditor，layer等。由于这些框架插件一般都要求不允许
					修改其文件目录结构，所有统一把整个文件夹拷贝到此处。页面引入规则：
					<script type="text/javascript" src="plugins/ckeditor/ckeditor.js"></script>
		|--pages	建议所有的jsp页面均存放于此处，且根据功能或所属业务分类，公共页面可以直接放到pages的根目录下
					也可以建立common文件夹，统一存放于此。
			|--users	如此结构，存放所有跟user相关的页面，出错或查找也更方便。
		|--static_pages	此目录下存放所有的HTML页面，且已经错过静态文件映射处理，如果有需要可以分类整理存放，同jsp
						的处理方式。		
	|--index.jsp	系统演示功能首页
	|--readme.txt	本说明文档
注：若日后有其他如swf文件、xml文件等操作，可以建立对应的文件夹目录，或者整理到统一文件夹中，并前往springmvc.xml中
	配置相关映射规则，参考其他静态资源。

