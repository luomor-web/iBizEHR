export interface NavDataElement {

    /**
     * 主键标识
     *
     * @memberof NavDataElement
     */
    id: string;

    /**
     * 视图标题
     *
     * @memberof NavDataElement
     */
    title: any;

    /**
     * 上下文
     *
     * @memberof NavDataElement
     */
    context:any;

    /**
     * 视图参数
     *
     * @memberof NavDataElement
     */
    viewparams:any;

    /**
     * 视图数据
     *
     * @memberof NavDataElement
     */   
    data:any;

    /**
     * 视图路径
     *
     * @memberof NavDataElement
     */ 
    path:string;

    /**
     * 元素主键
     *
     * @memberof NavDataElement
     */ 
    srfkey:string|null;

    /**
     * 视图标识
     *
     * @memberof NavDataElement
     */ 
    tag:string|null;

}

export interface ServiceState {

    /**
     * 行为
     *
     * @memberof ServiceState
     */
    action: string;

    /**
     * 名称
     *
     * @memberof ServiceState
     */
    name: any;

    /**
     * 数据
     *
     * @memberof ServiceState
     */
    data: any;

}

import { Subject } from 'rxjs';

/**
 * 导航数据服务
 * 
 * @export
 * @class CodeListService
 */
export default class NavDataService {

    /**
     * 单例变量声明
     *
     * @private
     * @static
     * @type {NavDataService}
     * @memberof NavDataService
     */
    private static navDataService: NavDataService;

    /**
     * 缓存对象
     *
     * @private
     * @type {(any)}
     * @memberof NavDataService
     */
    private static store: any;

    /**
     * 服务状态
     * 
     * @memberof NavDataService
     */
    public serviceState: Subject<ServiceState> = new Subject();

    /**
     * 导航数据栈
     * 
     * @memberof NavDataService
     */
    public navDataStack:Array<NavDataElement> = [];

    /**
     * 导航数据存储仓库
     * 
     * @memberof NavDataService
     */
    public sessionStore:any;

    /**
     * 初始化实例
     * 
     * @memberof NavDataService
     */
    constructor(opts:any = {}){
        this.sessionStore = window.sessionStorage;
        this.initNavData();
    }

    /**
     * 获取 NavDataService 单例对象
     *
     * @static
     * @returns {NavDataService}
     * @memberof NavDataService
     */
    public static getInstance(store: any): NavDataService {
        if (!NavDataService.navDataService) {
            NavDataService.navDataService = new NavDataService();
        }
        this.store = store;
        return this.navDataService;
    }

    /**
     * 初始化基础导航数据
     * 
     * @memberof NavDataService
     */
    public initNavData(){
        if(this.sessionStore && this.sessionStore.getItem('srfnavdata')){
            this.navDataStack = JSON.parse(this.sessionStore.getItem('srfnavdata'));
        }
    }

    /**
     * 添加基础导航数据到栈中
     * 
     * @memberof NavDataService
     */
    public addNavData(curNavData:NavDataElement){
        if(this.navDataStack.length >0){
            let tempIndex:number = this.navDataStack.findIndex((element:NavDataElement) =>{
                return Object.is(element.id,curNavData.id);
            })
            if(tempIndex === -1){
                this.navDataStack.push(curNavData);
                this.sessionStore.setItem('srfnavdata',JSON.stringify(this.navDataStack));
                return curNavData;
            }else{
                this.setNavDataById(curNavData.id,curNavData);
            }
        }else{
            this.navDataStack.push(curNavData);
            this.sessionStore.setItem('srfnavdata',JSON.stringify(this.navDataStack));
            return curNavData;
        }
        this.serviceState.next({action:'datarefresh',name:null,data:this.navDataStack});
    }

    /**
     * 设置指定数据到基础导航数据栈中
     * 
     * @memberof NavDataService
     */
    public setNavDataById(id:string,curNavData:NavDataElement){
        if(this.navDataStack.length >0){
            let tempIndex:number = this.navDataStack.findIndex((element:NavDataElement) =>{
                return Object.is(element.id,id);
            })
            this.navDataStack[tempIndex] = curNavData;
            this.sessionStore.setItem('srfnavdata',JSON.stringify(this.navDataStack));
            return curNavData;
        }else{
            return null;
        }
    }

    /**
     * 从导航数据栈中删除指定数据上层数据
     * 
     * @memberof NavDataService
     */
    public removeNavData(id:string){
        if(this.navDataStack.length >0){
            let tempIndex:number = this.navDataStack.findIndex((element:NavDataElement) =>{
                return Object.is(element.id,id);
            })
            let removeNavData = this.navDataStack.splice(tempIndex+1);
            if(removeNavData && removeNavData.length >0){
                removeNavData.forEach((navData:any) =>{
                    NavDataService.store.commit("deletePage", navData.path);
                })
            }
            this.sessionStore.setItem('srfnavdata',JSON.stringify(this.navDataStack));
            return removeNavData;
        }else{
            return null;
        }
    }

    /**
     * 从导航数据栈中删除指定数据上层数据(不清除页面缓存)
     * 
     * @memberof NavDataService
     */
    public removeNavDataWithoutCache(id:string){
        if(this.navDataStack.length >0){
            let tempIndex:number = this.navDataStack.findIndex((element:NavDataElement) =>{
                return Object.is(element.id,id);
            })
            let removeNavData = this.navDataStack.splice(tempIndex+1);
            this.sessionStore.setItem('srfnavdata',JSON.stringify(this.navDataStack));
            return removeNavData;
        }else{
            return null;
        }
    }

    /**
     * 从导航数据栈中获取指定数据
     * 
     * @memberof NavDataService
     */
    public getNavDataById(id:string){
        if(this.navDataStack.length >0){
            let tempIndex:number = this.navDataStack.findIndex((element:NavDataElement) =>{
                return Object.is(element.id,id);
            })
            return this.navDataStack[tempIndex];
        }else{
            return null;
        }
    }

    /**
     * 从导航数据栈中获取指定数据的前一条数据
     * 
     * @memberof NavDataService
     */
    public getPreNavDataById(id:string){
        if(this.navDataStack.length >0){
            let tempIndex:number = this.navDataStack.findIndex((element:NavDataElement) =>{
                return Object.is(element.id,id);
            })
            return this.navDataStack[tempIndex-1];
        }else{
            return null;
        }
    }

    /**
     * 清空导航数据栈数据
     * 
     * @memberof NavDataService
     */
    public clearNavData(id:string){
        this.navDataStack = [];
        this.sessionStore.setItem('srfnavdata',JSON.stringify(this.navDataStack));
    }

    /**
     * 从导航数据栈中获取数据
     * 
     * @memberof NavDataService
     */
    public getNavData(){
        if(this.navDataStack && this.navDataStack.length >0){
            this.navDataStack.forEach((item:any,index) =>{
                if(item && item.data && this.navDataStack[index+1]){
                    this.navDataStack[index+1] = Object.assign(this.navDataStack[index+1],{isselected:true});
                }
            })
            return this.navDataStack;
        }else{
            return [];
        }
    }

    /**
     * 从导航数据栈中直接添加数据
     * 
     * @memberof NavDataService
     */    
    public addNavDataByOnly(curNavData:NavDataElement,isOnlyAdd:boolean){
        if(isOnlyAdd){
            this.navDataStack.push(curNavData);
        }else{
            if(this.navDataStack.length >0){
                let tempIndex:number = this.navDataStack.findIndex((element:NavDataElement) =>{
                    return Object.is(element.tag,curNavData.tag);
                })
                if(tempIndex === -1){
                    this.navDataStack.push(curNavData);
                }else{
                    this.navDataStack[tempIndex] = curNavData;
                }
            }else{
                this.navDataStack.push(curNavData);
            }
        }
        this.sessionStore.setItem('srfnavdata',JSON.stringify(this.navDataStack));
        return curNavData;
    }

    /**
     * 从导航数据栈中直接删除数据
     * 
     * @memberof NavDataService
     */    
    public removeNavDataByTag(viewtag:string){
        if(this.navDataStack.length >0){
            let tempIndex:number = this.navDataStack.findIndex((element:NavDataElement) =>{
                return Object.is(element.tag,viewtag);
            })
            let removeNavData = this.navDataStack.splice(tempIndex,1);
            this.sessionStore.setItem('srfnavdata',JSON.stringify(this.navDataStack));
            return removeNavData;
        }else{
            return null;
        }
    }

    /**
     * 从导航数据栈中获取指定元素前一个元素
     * 
     * @memberof NavDataService
     */    
    public getPreNavDataByTag(viewtag:string){
        if(this.navDataStack.length >0){
            let tempIndex:number = this.navDataStack.findIndex((element:NavDataElement) =>{
                return Object.is(element.tag,viewtag);
            })
            return this.navDataStack[tempIndex - 1]?this.navDataStack[tempIndex - 1]:null;
        }else{
            return null;
        }
    }

    /**
     * 从导航数据栈中删除所有数据
     * 
     * @memberof NavDataService
     */    
    public removeAllNavData(){
        if(this.navDataStack.length >0){
            this.navDataStack = [];
            this.sessionStore.setItem('srfnavdata',JSON.stringify(this.navDataStack));
        }
    }
}