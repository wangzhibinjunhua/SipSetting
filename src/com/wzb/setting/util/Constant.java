package com.wzb.setting.util;

public class Constant {

	// 存储文件名称
	public static final String ROUTE1 = "route1";
	public static final String ROUTE2 = "route2";
	public static final String ROUTE3 = "route3";
	public static final String ROUTE4 = "route4";
	public static final String sipuri = "sipuri";
	public static final String openregister = "openregister"; // 注册状态
	public static final String registerstart = "registerstart"; // 开启注册
	public static final String serveraddress = "serveraddress"; // 服务器地址
	public static final String serverport = "serverport"; // 服务器端口
	public static final String backserveraddress = "backserveraddress"; // 备用服务器地址
	public static final String backserverport = "backserverport"; // 备用服务器端口
	public static final String username = "username"; // 用户名
	public static final String password = "password"; // 密码
	public static final String phone = "phone"; // 电话号码
	public static final String showname = "showname"; // 显示名称
	public static final String localdomainname = "localdomainname"; // 本地域名
	public static final String transport = "transport"; // 传输类型
	
	public static final String proxyaddress = "proxyaddress"; // 代理服务器地址
	public static final String proxyport = "proxyport"; // 代理服务器端口
	public static final String proxyname = "proxyname"; // 代理服务器账号
	public static final String proxypassword = "proxypassword"; // 代理服务器密码
	public static final String backupproxyaddress = "backupproxyaddress"; // 备份代理服务器地址
	public static final String backupproxyport = "backupproxyport"; // 备份代理服务器端口
	public static final String servername = "servername"; // 服务器名称
	public static final String registertime = "registertime"; // 服务器注册时限
	public static final String DTMFtype = "DTMFtype"; // DTMF类型
	public static final String useSTUN = "useSTUN"; // 使用STUN
	public static final String forbidcall = "forbidcall"; // 禁止服务呼叫
	public static final String openBLFList = "openBLFList"; // 开启BLF List
	public static final String BLFListnumber = "BLFListnumber"; // BLF List号码
	public static final String opensessiontimer = "opensessiontimer"; // 开启会话计时
	public static final String sessiontimeout = "sessiontimeout"; // 会话超时时间
	public static final String specificationversion = "specificationversion"; // 规范版本
	public static final String anonymitspecification = "anonymityspecification"; // 匿名呼叫规范版本
	public static final String transportprotocols = "transportprotocols"; // 传输协议
	public static final String openRport = "openRport"; // 开启Rport
	public static final String openPRACK = "openPRACK"; // 开启PRACK
	public static final String startTeltypecall = "startTeltypecall"; // 启用Tel格式呼叫
	public static final String calleridentification = "calleridentification"; // 来电显示类型
	public static final String specialserver = "specialserver"; // 配置兼容特殊服务器
	public static final String URItransition = "URItransition"; // 允许URI转换
	public static final String namequotationmark = "namequotationmark"; // 配置显示名称加引号
	public static final String voicemessage = "voicemessage"; // 启用语音留言
	public static final String openDNSSRV = "openDNSSRV"; // 开启DNS SRV
	public static final String startpreview = "startpreview"; // 启用预览
	public static final String previewpattern = "previewpattern"; // 预览模式

	// 服务
	public static final String SERVICE1 = "service1";
	public static final String SERVICE2 = "service2";
	public static final String SERVICE3 = "service3";
	public static final String SERVICE4 = "service4";
	public static final String autoswitchover = "autoswitchover"; // 启用自动转接
	public static final String autoanswertime = "autoanswertime"; // 自动接听等候时间(0~120)
	public static final String openunconditional = "openunconditional"; // 开启无条件前转
	public static final String openbusy = "openbusy"; // 开启遇忙前转
	public static final String opennoanswer = "opennoanswer"; // 开启无应答前转
	public static final String unconditionalturn = "unconditionalturn"; // 无条件前转号码
	public static final String busyturn = "busyturn"; // 遇忙前转号码
	public static final String noanswerturn = "noanswerturn"; // 无应答前转号码
	public static final String noanswerovertime = "noanswerovertime"; // 无应答转移超时时间(0~120)
	public static final String openhotline = "openhotline"; // 开启热线
	public static final String hotlinenumber = "hotlinenumber"; // 热线号码
	public static final String hotlinedelaytime = "hotlinedelaytime"; // 热线延迟时间(0~9)
	public static final String openmisscall = "openmisscall"; // 开启未接来电记录
	public static final String notregistercall = "notregistercall"; // 允许不注册呼叫
	public static final String voicemailnumber = "voicemailnumber"; // 语音信箱号码
	public static final String routering = "routering"; // 选择线路铃声
	public static final String showcalltype = "showcalltype"; // 来电显示类型
	public static final String openuserphone = "openuserphone"; // 开启User=phone

	// 功能
	public static final String function = "function";
	public static final String callwait = "callwait"; // 开启呼叫等待
	public static final String calldivert = "calldivert"; // 开启呼叫转移
	public static final String halfattendturn = "halfattendturn"; // 开启半出席转
	public static final String autohangup = "autohangup"; // 免提自动挂断
	public static final String autohanguptime = "autohanguptime"; // 免提自动挂断时间(0~30)
	public static final String openthreeparty = "openthreeparty"; // 开启三方通话
	public static final String headsetring = "headsetring"; // 耳麦振铃
	public static final String autoEarphone = "autoEarphone"; // 自动选择耳机

	public static final String hideDTMF = "hideDTMF"; // 隐藏DTMF
	public static final String forbidcallout = "forbidcallout"; // 禁止呼出
	public static final String callhistory = "callhistory"; // 启用通话记录
	public static final String calloutside = "calloutside"; // 默认呼叫外线
	public static final String callmode = "callmode"; // 默认呼叫模式
	public static final String answermode = "answermode"; // 默认接听模式
	public static final String IPcall = "IPcall"; // 允许IP通话
	public static final String urgentnumber = "urgentnumber"; // 配置紧急号码
	public static final String openMultiLine = "openMultiLine"; // 开启Multi
																// Line

	public static final String limitActiveURI = "limitActiveURI"; // 限制ActiveURI来源IP
	public static final String callwaitvoice = "callwaitvoice"; // 开启呼叫等待音
	public static final String callDTMFvoice = "callDTMFvoice"; // 通话DTMF提示音
	public static final String dialDTMFvoice = "dialDTMFvoice"; // 拨号DTMF提示音
	public static final String passwordcall = "passwordcall"; // 密码拨打
	public static final String passwordcallprefix = "passwordcallprefix"; // 密码拨打前缀
	public static final String passwordlong = "passwordlong"; // 密码长度(0~31)
	public static final String finishcall = "finishcall"; // 通话完成
	public static final String autoredial = "autoredial"; // 自动重拨
	public static final String autoredialinterval = "autoredialinterval"; // 自动重拨间隔(1~180)
	public static final String autoredialcount = "autoredialcount"; // 自动重拨次数(1~100)
	public static final String talkbackmode = "talkbackmode"; // 对讲模式
	public static final String talkbackmodemute = "talkbackmodemute"; // 对讲模式静音
	public static final String talkbackmodering = "talkbackmodering"; // 对讲模式响铃
	public static final String secondtalkbackanswer = "secondtalkbackanswer"; // 第二路对讲接听
	public static final String busyresponsecode = "busyresponsecode"; // 遇忙响应码
	public static final String hidelocalcode = "hidelocalcode"; // 隐藏本地区号
	public static final String countrycode = "countrycode"; // 国家代码
	public static final String regioncode = "regioncode"; // 地区代码
	public static final String SIPnumber = "SIPnumber"; // 使用SIP编号方案
	public static final String updatecallnumber = "updatecallnumber"; // 更新呼叫号码
	public static final String onekeytransfer = "onekeytransfer"; // 一键转移
	public static final String videomode = "videomode"; // 接收视频模式
	public static final String threecallprocedure = "threecallprocedure"; // 开启第三方通话程序
	public static final String threecallsoftware = "threecallsoftware"; // 摘机打开第三方通话软件

	// 收号规则
	public static final String collectrule = "collectrule";
	public static final String endingcollect = "endingcollect"; // 以#结尾收号
	public static final String overtimecollect = "overtimecollect"; // 超时收号(3~30)
	public static final String overtimecollectrange = "overtimecollectrange"; // 超时收号范围(3~30)
	public static final String endingturn = "endingturn"; // 以#结尾盲转
	public static final String hangturn = "hangturn"; // 挂机盲转
	public static final String hangattendturn = "hangattendturn"; // 挂机出席转
	public static final String meetinghangattendturn = "meetinghangattendturn"; // 会议挂机出席转
}
