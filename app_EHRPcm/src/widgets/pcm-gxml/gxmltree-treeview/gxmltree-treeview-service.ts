import { Http,Util,Errorlog } from '@/utils';
import ControlService from '@/widgets/control-service';
import PcmGxmlService from '@/service/pcm-gxml/pcm-gxml-service';
import GXMLtreeModel from './gxmltree-treeview-model';
import CodeListService from '@service/app/codelist-service';
import i18n from '@/locale';


/**
 * GXMLtree 部件服务对象
 *
 * @export
 * @class GXMLtreeService
 */
export default class GXMLtreeService extends ControlService {

    /**
     * 高校名录服务对象
     *
     * @type {PcmGxmlService}
     * @memberof GXMLtreeService
     */
    public appEntityService: PcmGxmlService = new PcmGxmlService({ $store: this.getStore() });

    /**
     * 设置从数据模式
     *
     * @type {boolean}
     * @memberof GXMLtreeService
     */
    public setTempMode(){
        this.isTempMode = false;
    }

    /**
     * Creates an instance of GXMLtreeService.
     * 
     * @param {*} [opts={}]
     * @memberof GXMLtreeService
     */
    constructor(opts: any = {}) {
        super(opts);
        this.model = new GXMLtreeModel();
    }


    /**
     * 代码表服务对象
     *
     * @type {CodeListService}
     * @memberof GXMLtreeService
     */
    public codeListService:CodeListService = new CodeListService({ $store: this.getStore() });


    /**
     * 节点分隔符号
     *
     * @public
     * @type {string}
     * @memberof GXMLtreeService
     */
    public TREENODE_SEPARATOR: string = ';';

    /**
     * 默认根节点节点分隔符号
     *
     * @public
     * @type {string}
     * @memberof GXMLtreeService
     */
	public TREENODE_ROOT: string = 'ROOT';

    /**
     * 根节点节点分隔符号
     *
     * @public
     * @type {string}
     * @memberof GXMLtreeService
     */
	public TREENODE_PCMGXML: string = 'PCMGXML';

    /**
     * 获取节点数据
     *
     * @param {string} action
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof GXMLtreeService
     */
    @Errorlog
    public async getNodes(context:any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let { srfparentkey, srfcat, srfnodeid, srfnodefilter, query }: { srfparentkey: string, srfcat: string, srfnodeid: string, srfnodefilter: string, query:string } = data;
        srfnodefilter = query ? query : srfnodefilter;
        let list: any[] = [];
        let filter: any = {};


        if (!srfnodeid || Object.is(srfnodeid, '#')) {
            srfnodeid = this.TREENODE_ROOT;
        }

        let strTreeNodeId: string = srfnodeid;
        let strRealNodeId: string = '';
        let bRootSelect: boolean = false;
        let strNodeType: string | null = null;
        let strRootSelectNode: string = '';

        if (Object.is(strTreeNodeId, this.TREENODE_ROOT)) {
            strNodeType = this.TREENODE_ROOT;
            if (srfparentkey) {
                strRealNodeId = srfparentkey;
            }
        } else {
            let nPos = strTreeNodeId.indexOf(this.TREENODE_SEPARATOR);
            if (nPos === -1) {
                return Promise.reject({ status: 500, data: { title: '失败', message: `树节点${strTreeNodeId}标识无效` } });
            }
            strNodeType = strTreeNodeId.substring(0, nPos);
			strRealNodeId = strTreeNodeId.substring(nPos + 1);
        }

        Object.assign(filter,
            {
                srfparentkey: srfparentkey,
                srfcat: srfcat,
                srfnodefilter: srfnodefilter,
                strRealNodeId: strRealNodeId,
                srfnodeid: srfnodeid,
                strNodeType: strNodeType,
                viewparams: JSON.parse(JSON.stringify(data)).viewparams
            }
        );

        // 分解节点标识
        let nodeid: string[] = strRealNodeId.split(this.TREENODE_SEPARATOR);
        for (let i = 0; i < nodeid.length; i++) {
            switch (i) {
                case 0:
                    Object.assign(filter, { nodeid: nodeid[0] });
                    break;
                case 1:
                    Object.assign(filter, { nodeid2: nodeid[1] });
                    break;
                case 2:
                    Object.assign(filter, { nodeid3: nodeid[2] });
                    break;
                case 3:
                    Object.assign(filter, { nodeid4: nodeid[3] });
                    break;
                default:
                    break;
            }
        }

        if (Object.is(strNodeType, this.TREENODE_ROOT)) {
            await this.fillRootNodeChilds(context,filter, list);
            return Promise.resolve({ status: 200, data: list });
        }
        if (Object.is(strNodeType, this.TREENODE_PCMGXML)) {
            await this.fillPcmgxmlNodeChilds(context,filter, list);
            return Promise.resolve({ status: 200, data: list });
        }
        return Promise.resolve({ status: 500, data: { title: '失败', message: `树节点${strTreeNodeId}标识无效` } });
    }

    /**
     * 填充 树视图节点[默认根节点]
     *
     * @public
     * @param {any{}} context     
     * @param {*} filter
     * @param {any[]} list
     * @param {*} rsNavContext   
     * @param {*} rsNavParams
     * @param {*} rsParams
     * @returns {Promise<any>}
     * @memberof GXMLtreeService
     */
    @Errorlog
    public fillRootNodes(context:any={},filter: any, list: any[],rsNavContext?:any,rsNavParams?:any,rsParams?:any): Promise<any> {
        context = this.handleResNavContext(context,filter,rsNavContext);
        filter = this.handleResNavParams(context,filter,rsNavParams,rsParams);
        return new Promise((resolve:any,reject:any) =>{
            let treeNode: any = {};
            Object.assign(treeNode, { text: 'entities.pcmgxml.gxmltree_treeview.nodes.root' });
            Object.assign(treeNode, { isUseLangRes: true });
            Object.assign(treeNode,{srfappctx:context});
            Object.assign(treeNode, { srfmajortext: treeNode.text });
            let strNodeId: string = 'ROOT';

            Object.assign(treeNode, { srfkey: 'root' });
            strNodeId += this.TREENODE_SEPARATOR;
            strNodeId += 'root';

            Object.assign(treeNode, { id: strNodeId });

            Object.assign(treeNode, { expanded: filter.isAutoexpand });
            Object.assign(treeNode, { leaf: false });
            Object.assign(treeNode, { nodeid: treeNode.srfkey });
            Object.assign(treeNode, { nodeid2: filter.strRealNodeId });
            list.push(treeNode);
            resolve(list);
        });
	}

    /**
     * 填充 树视图节点[默认根节点]子节点
     *
     * @public
     * @param {any{}} context         
     * @param {*} filter
     * @param {any[]} list
     * @returns {Promise<any>}
     * @memberof GXMLtreeService
     */
    @Errorlog
    public async fillRootNodeChilds(context:any={}, filter: any, list: any[]): Promise<any> {
		if (filter.srfnodefilter && !Object.is(filter.srfnodefilter,"")) {
			// 填充根节点
            let PcmgxmlRsNavContext:any = {};
            let PcmgxmlRsNavParams:any = {};
            let PcmgxmlRsParams:any = {};
			await this.fillPcmgxmlNodes(context, filter, list ,PcmgxmlRsNavContext,PcmgxmlRsNavParams,PcmgxmlRsParams);
		} else {
			// 填充根节点
            let PcmgxmlRsNavContext:any = {};
            let PcmgxmlRsNavParams:any = {};
            let PcmgxmlRsParams:any = {};
			await this.fillPcmgxmlNodes(context, filter, list ,PcmgxmlRsNavContext,PcmgxmlRsNavParams,PcmgxmlRsParams);
		}
	}

    /**
     * 填充 树视图节点[根节点]
     *
     * @public
     * @param {any{}} context     
     * @param {*} filter
     * @param {any[]} list
     * @param {*} rsNavContext   
     * @param {*} rsNavParams
     * @param {*} rsParams
     * @returns {Promise<any>}
     * @memberof GXMLtreeService
     */
    @Errorlog
    public fillPcmgxmlNodes(context:any={},filter: any, list: any[],rsNavContext?:any,rsNavParams?:any,rsParams?:any): Promise<any> {
        context = this.handleResNavContext(context,filter,rsNavContext);
        filter = this.handleResNavParams(context,filter,rsNavParams,rsParams);
        return new Promise((resolve:any,reject:any) =>{
            let codeListIems:Array<any> = [];
            if (this.getStore()) {
                codeListIems = (this.getStore() as any).getters.getCodeListItems('EhrCodeList0009');
            }
            if(codeListIems && codeListIems.length >0){
                const handleChildData = (context:any,item:any,) =>{
                    Object.assign(item,{srfappctx:context});
                    Object.assign(item, { text: 'codelist.EhrCodeList0009.'+item.value });
                    Object.assign(item, { isUseLangRes: true });
                    Object.assign(item, { srfmajortext: item.text });
                    let strNodeId: string = "PCMGXML";
                    Object.assign(item, { srfkey: item.value });
                    strNodeId += this.TREENODE_SEPARATOR;
                    strNodeId += item.value;
                    Object.assign(item, { id: strNodeId });
                    Object.assign(item, { expanded: filter.isautoexpand });
                    Object.assign(item, { navfilter: "n_nd_eq" });
                    Object.assign(item, {navigateParams: {nodeid:"%NODEID%"} });
                    Object.assign(item, { nodeid: item.srfkey });
                    Object.assign(item, { nodeid2: item.pvalue });
                }
                codeListIems = this.handleDataSet(JSON.parse(JSON.stringify(codeListIems)),context,handleChildData);
                codeListIems.forEach((item:any) => {
                    let treeNode: any = {};
                    Object.assign(treeNode,{srfappctx:context});
                    Object.assign(treeNode, { text: 'codelist.EhrCodeList0009.'+item.value });
                    Object.assign(treeNode, { isUseLangRes: true });
                    Object.assign(treeNode, { srfmajortext: treeNode.text });
                    let strNodeId: string = "PCMGXML";
                    Object.assign(treeNode, { srfkey: item.value });
                    strNodeId += this.TREENODE_SEPARATOR;
                    strNodeId += item.value;
                    Object.assign(treeNode, { id: strNodeId });
                    Object.assign(treeNode, { expanded: filter.isautoexpand });
                    Object.assign(treeNode, { leaf: true });
                    Object.assign(treeNode, { navfilter: "n_nd_eq" });
                    Object.assign(treeNode, {navigateParams: {nodeid:"%NODEID%"} });
                    if(item.children && item.children.length >0){
                        Object.assign(treeNode, { children: item.children });
                    }
                    Object.assign(treeNode, { nodeid: treeNode.srfkey });
                    Object.assign(treeNode, { nodeid2: filter.strRealNodeId });
                    list.push(treeNode);
                    resolve(list);
                })
             }else{
                resolve(list);
             }
        });
	}

    /**
     * 填充 树视图节点[根节点]子节点
     *
     * @public
     * @param {any{}} context         
     * @param {*} filter
     * @param {any[]} list
     * @returns {Promise<any>}
     * @memberof GXMLtreeService
     */
    @Errorlog
    public async fillPcmgxmlNodeChilds(context:any={}, filter: any, list: any[]): Promise<any> {
		if (filter.srfnodefilter && !Object.is(filter.srfnodefilter,"")) {
		} else {
		}
	}


    /**
     * 处理代码表返回数据(树状结构)
     * 
     * @param result 返回数组
     * @param context 应用上下文
     * @param callBack 回调
     * @memberof GXMLtreeService
     */
    public handleDataSet(result:Array<any>,context:any,callBack:any){
        let list:Array<any> = [];
        if(result.length === 0){
            return list;
        }
        result.forEach((codeItem:any) =>{
            if(!codeItem.pvalue){
                let valueField:string = codeItem.value;
                this.setChildCodeItems(valueField,result,codeItem);
                list.push(codeItem);
            }
        })
        this.setNodeData(list,context,callBack);
        return list;
    }

    /**
     * 处理非根节点数据
     * 
     * @param result 返回数组
     * @param context 应用上下文
     * @param callBack 回调
     * @memberof GXMLtreeService
     */
    public setChildCodeItems(pValue:string,result:Array<any>,codeItem:any){
        result.forEach((item:any) =>{
            if(item.pvalue == pValue){
                let valueField:string = item.value;
                this.setChildCodeItems(valueField,result,item);
                if(!codeItem.children){
                    codeItem.children = [];
                }
                codeItem.children.push(item);
            }
        })
    }

    /**
     * 设置节点UI数据
     * 
     * @param result 返回数组
     * @param context 应用上下文
     * @param callBack 回调
     * @memberof GXMLtreeService
     */
    public setNodeData(result:Array<any>,context:any,callBack:any){
        result.forEach((item:any) =>{
            if(item.children){
                item.leaf = false;
                this.setNodeData(item.children,context,callBack);
            }else{
                item.leaf = true;
            }
            callBack(context,item);
        })
    }

    /**
     * 处理节点关系导航上下文
     *
     * @param context 应用上下文
     * @param filter 参数 
     * @param resNavContext 节点关系导航上下文
     *
     * @memberof GXMLtreeService
     */
    public handleResNavContext(context:any,filter:any,resNavContext:any){
        if(resNavContext && Object.keys(resNavContext).length > 0){
            let tempContextData:any = JSON.parse(JSON.stringify(context));
            let tempViewParams:any = {};
            if(filter && filter.viewparams){
                tempViewParams = filter.viewparams;
            }
            Object.keys(resNavContext).forEach((item:any) =>{
                let curDataObj:any = resNavContext[item];
                this.handleCustomDataLogic(context,tempViewParams,curDataObj,tempContextData,item);
            })
            return tempContextData;
        }else{
            return context;
        }
    }

    /**
     * 处理关系导航参数
     *
     * @param context 应用上下文
     * @param filter 参数 
     * @param resNavParams 节点关系导航参数
     * @param resParams 节点关系参数
     *
     * @memberof GXMLtreeService
     */
	public handleResNavParams(context:any,filter:any,resNavParams:any,resParams:any){
        if((resNavParams && Object.keys(resNavParams).length >0) || (resParams && Object.keys(resParams).length >0)){
            let tempViewParamData:any = {};
            let tempViewParams:any = {};
            if(filter && filter.viewparams){
                tempViewParams = filter.viewparams;
                tempViewParamData = JSON.parse(JSON.stringify(filter.viewparams));
            }
            if( Object.keys(resNavParams).length > 0){
                Object.keys(resNavParams).forEach((item:any) =>{
                    let curDataObj:any = resNavParams[item];
                    this.handleCustomDataLogic(context,tempViewParams,curDataObj,tempViewParamData,item);
                })
            }
            if( Object.keys(resParams).length > 0){
                Object.keys(resParams).forEach((item:any) =>{
                    let curDataObj:any = resParams[item];
                    tempViewParamData[item.toLowerCase()] = curDataObj.value;
                })
            }
            Object.assign(filter,{viewparams:tempViewParamData});
            return filter;
        }else{
            return filter;
        }
    }
    
    /**
     * 处理自定义节点关系导航数据
     * 
     * @param context 应用上下文
     * @param viewparams 参数 
     * @param curNavData 节点关系导航参数对象
     * @param tempData 返回数据
     * @param item 节点关系导航参数键值
     *
     * @memberof GXMLtreeService
     */
	public handleCustomDataLogic(context:any,viewparams:any,curNavData:any,tempData:any,item:string){
		// 直接值直接赋值
		if(curNavData.isRawValue){
			if(Object.is(curNavData.value,"null") || Object.is(curNavData.value,"")){
                Object.defineProperty(tempData, item.toLowerCase(), {
                    value: null,
                    writable : true,
                    enumerable : true,
                    configurable : true
                });
            }else{
                Object.defineProperty(tempData, item.toLowerCase(), {
                    value: curNavData.value,
                    writable : true,
                    enumerable : true,
                    configurable : true
                });
            }
		}else{
			// 先从导航上下文取数，没有再从导航参数（URL）取数，如果导航上下文和导航参数都没有则为null
			if(context[(curNavData.value).toLowerCase()]){
				Object.defineProperty(tempData, item.toLowerCase(), {
					value: context[(curNavData.value).toLowerCase()],
					writable : true,
					enumerable : true,
					configurable : true
				});
			}else{
				if(viewparams[(curNavData.value).toLowerCase()]){
					Object.defineProperty(tempData, item.toLowerCase(), {
						value: viewparams[(curNavData.value).toLowerCase()],
						writable : true,
						enumerable : true,
						configurable : true
					});
				}else{
					Object.defineProperty(tempData, item.toLowerCase(), {
						value: null,
						writable : true,
						enumerable : true,
						configurable : true
					});
				}
			}
		}
	}

}