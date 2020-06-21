import qs from 'qs';
import { MockAdapter } from '@/mock/mock-adapter';
const mock = MockAdapter.getInstance();

// 模拟数据
const mockDatas: Array<any> = [
    {"sxzy":null,"jlczz":null,"ygbh":null,"ormorgsectorid":null,"bz":null,"reason":null,"xl":null,"xkml":null,"jymc":null,"jssj":null,"ormorgid":null,"bdwgznx":null,"createdate":"2020-06-21 17:12:07","enable":1,"updateman":"示例操作者","zjxtgznx":null,"srfkey":"1","gznx":null,"cjgzsj":null,"qssj":null,"fj":null,"pimeducationname":"教育信息","pimeducationid":"1","orgid":null,"bjgznx":null,"xllx":null,"spstate":null,"jlss":null,"byyx":null,"orgsectorid":null,"tozjdate":null,"btz":null,"pimpersonid":null,"sfdyxl":null,"xxxz":null,"xlcx":null,"sfzgxl":null,"jlspzt":null,"xwz":null,"degree":null,"jlglbh":null,"dbdwsj":null,"dzjbjsj":null,"updatedate":"2020-06-21 17:12:07","createman":"示例操作者","pimpersonname":null},
    {"sxzy":null,"jlczz":null,"ygbh":null,"ormorgsectorid":null,"bz":null,"reason":null,"xl":null,"xkml":null,"jymc":null,"jssj":null,"ormorgid":null,"bdwgznx":null,"createdate":"2020-06-21 17:12:07","enable":1,"updateman":"示例操作者","zjxtgznx":null,"srfkey":"2","gznx":null,"cjgzsj":null,"qssj":null,"fj":null,"pimeducationname":"教育信息(1)","pimeducationid":"2","orgid":null,"bjgznx":null,"xllx":null,"spstate":null,"jlss":null,"byyx":null,"orgsectorid":null,"tozjdate":null,"btz":null,"pimpersonid":null,"sfdyxl":null,"xxxz":null,"xlcx":null,"sfzgxl":null,"jlspzt":null,"xwz":null,"degree":null,"jlglbh":null,"dbdwsj":null,"dzjbjsj":null,"updatedate":"2020-06-21 17:12:07","createman":"示例操作者","pimpersonname":null},
    {"sxzy":null,"jlczz":null,"ygbh":null,"ormorgsectorid":null,"bz":null,"reason":null,"xl":null,"xkml":null,"jymc":null,"jssj":null,"ormorgid":null,"bdwgznx":null,"createdate":"2020-06-21 17:12:07","enable":1,"updateman":"示例操作者","zjxtgznx":null,"srfkey":"3","gznx":null,"cjgzsj":null,"qssj":null,"fj":null,"pimeducationname":"教育信息(2)","pimeducationid":"3","orgid":null,"bjgznx":null,"xllx":null,"spstate":null,"jlss":null,"byyx":null,"orgsectorid":null,"tozjdate":null,"btz":null,"pimpersonid":null,"sfdyxl":null,"xxxz":null,"xlcx":null,"sfzgxl":null,"jlspzt":null,"xwz":null,"degree":null,"jlglbh":null,"dbdwsj":null,"dzjbjsj":null,"updatedate":"2020-06-21 17:12:07","createman":"示例操作者","pimpersonname":null},
    {"sxzy":null,"jlczz":null,"ygbh":null,"ormorgsectorid":null,"bz":null,"reason":null,"xl":null,"xkml":null,"jymc":null,"jssj":null,"ormorgid":null,"bdwgznx":null,"createdate":"2020-06-21 17:12:07","enable":1,"updateman":"示例操作者","zjxtgznx":null,"srfkey":"4","gznx":null,"cjgzsj":null,"qssj":null,"fj":null,"pimeducationname":"教育信息(3)","pimeducationid":"4","orgid":null,"bjgznx":null,"xllx":null,"spstate":null,"jlss":null,"byyx":null,"orgsectorid":null,"tozjdate":null,"btz":null,"pimpersonid":null,"sfdyxl":null,"xxxz":null,"xlcx":null,"sfzgxl":null,"jlspzt":null,"xwz":null,"degree":null,"jlglbh":null,"dbdwsj":null,"dzjbjsj":null,"updatedate":"2020-06-21 17:12:07","createman":"示例操作者","pimpersonname":null},
    {"sxzy":null,"jlczz":null,"ygbh":null,"ormorgsectorid":null,"bz":null,"reason":null,"xl":null,"xkml":null,"jymc":null,"jssj":null,"ormorgid":null,"bdwgznx":null,"createdate":"2020-06-21 17:12:07","enable":1,"updateman":"示例操作者","zjxtgznx":null,"srfkey":"5","gznx":null,"cjgzsj":null,"qssj":null,"fj":null,"pimeducationname":"教育信息(4)","pimeducationid":"5","orgid":null,"bjgznx":null,"xllx":null,"spstate":null,"jlss":null,"byyx":null,"orgsectorid":null,"tozjdate":null,"btz":null,"pimpersonid":null,"sfdyxl":null,"xxxz":null,"xlcx":null,"sfzgxl":null,"jlspzt":null,"xwz":null,"degree":null,"jlglbh":null,"dbdwsj":null,"dzjbjsj":null,"updatedate":"2020-06-21 17:12:07","createman":"示例操作者","pimpersonname":null},
    {"sxzy":null,"jlczz":null,"ygbh":null,"ormorgsectorid":null,"bz":null,"reason":null,"xl":null,"xkml":null,"jymc":null,"jssj":null,"ormorgid":null,"bdwgznx":null,"createdate":"2020-06-21 17:12:07","enable":1,"updateman":"示例操作者","zjxtgznx":null,"srfkey":"6","gznx":null,"cjgzsj":null,"qssj":null,"fj":null,"pimeducationname":"教育信息(5)","pimeducationid":"6","orgid":null,"bjgznx":null,"xllx":null,"spstate":null,"jlss":null,"byyx":null,"orgsectorid":null,"tozjdate":null,"btz":null,"pimpersonid":null,"sfdyxl":null,"xxxz":null,"xlcx":null,"sfzgxl":null,"jlspzt":null,"xwz":null,"degree":null,"jlglbh":null,"dbdwsj":null,"dzjbjsj":null,"updatedate":"2020-06-21 17:12:07","createman":"示例操作者","pimpersonname":null}
];


//getwflink
mock.onGet(new RegExp(/^\/wfcore\/ehr-app-ehrhelp\/pimeducations\/[a-zA-Z0-9\-\;]+\/usertasks\/[a-zA-Z0-9\-\;]+\/ways$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: getwflink");
    console.table({url:config.url, method: config.method, data:config.data});
    console.groupEnd();
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, {}];
    }
    return [status,[
        {"sequenceFlowId":"dfdsfdsfdsfdsfds","sequenceFlowName":"同意",
         "taskId":"aaaaddddccccddddd","processDefinitionKey":"support-workorders-approve-v1",
         "processInstanceId":"ddlfldldfldsfds","refViewKey":""},
        {"sequenceFlowId":"ddssdfdfdfdfsfdf","sequenceFlowName":"不同意",
         "taskId":"aaaaddddccccddddd","processDefinitionKey":"support-workorders-approve-v1",
         "processInstanceId":"ddfdsldlfdlldsf","refViewKey":"workorder_ltform_editview"}
        ]];
});

// getwfstep
mock.onGet(new RegExp(/^\/wfcore\/ehr-app-ehrhelp\/pimeducations\/process-definitions-nodes$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: getwfstep");
    console.table({url:config.url, method: config.method, data:config.data});
    console.groupEnd();
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, {}];
    }
    return [status, [
        {"userTaskId":"sddfddfd-dfdf-fdfd-fdf-dfdfd",
        "userTaskName":"待审",
        "cnt":0,
        "processDefinitionKey":"support-workorders-approve-v1",
        "processDefinitionName":"工单审批流程v1"
        },
        {"userTaskId":"sddfddfd-dfdf-fdfd-fdf-87927",
        "userTaskName":"待分配",
        "cnt":3,
        "processDefinitionKey":"support-workorders-approve-v1",
        "processDefinitionName":"工单审批流程v1"}
        ]];
});

// createBatch
mock.onPost(new RegExp(/^\/pimeducations\/batch$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: createBatch");
    console.table({url:config.url, method: config.method, data:config.data});
    console.groupEnd();
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, {}];
    }
    return [status, {}];
});

// updateBatch
mock.onPut(new RegExp(/^\/pimeducations\/batch$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: updateBatch");
    console.table({url:config.url, method: config.method, data:config.data});
    console.groupEnd();
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, {}];
    }
    return [status, {}];
});

// removeBatch
mock.onDelete(new RegExp(/^\/pimeducations\/batch$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: removeBatch");
    console.table({url:config.url, method: config.method, data:config.data});
    console.groupEnd();
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, {}];
    }
    return [status, {}];
});



// Select
mock.onGet(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimeducations\/([a-zA-Z0-9\-\;]{1,35})\/select$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: Select");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimeducationid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimeducations\/([a-zA-Z0-9\-\;]{1,35})\/select$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    let _items = items.find((item: any) => Object.is(item.pimeducationid, tempValue.pimeducationid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items);
    console.groupEnd();
    console.groupEnd();
    return [status, _items];
});

// Select
mock.onGet(new RegExp(/^\/pimeducations\/([a-zA-Z0-9\-\;]{1,35})\/select$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: Select");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimeducationid'];
    const matchArray:any = new RegExp(/^\/pimeducations\/([a-zA-Z0-9\-\;]{1,35})\/select$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    let _items = items.find((item: any) => Object.is(item.pimeducationid, tempValue.pimeducationid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items);
    console.groupEnd();
    console.groupEnd();
    return [status, _items];
});

    
// CheckHighestEdu
mock.onPost(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimeducations\/([a-zA-Z0-9\-\;]{1,35})\/checkhighestedu$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: CheckHighestEdu");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimeducationid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimeducations\/([a-zA-Z0-9\-\;]{1,35})\/checkhighestedu$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});
        
// CheckHighestEdu
mock.onPost(new RegExp(/^\/pimeducations\/?([a-zA-Z0-9\-\;]{0,35})\/checkhighestedu$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: CheckHighestEdu");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimeducationid'];
    const matchArray:any = new RegExp(/^\/pimeducations\/([a-zA-Z0-9\-\;]{1,35})\/checkhighestedu$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    //let items = mockDatas ? mockDatas : [];
    //let _items = items.find((item: any) => Object.is(item.pimeducationid, tempValue.pimeducationid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pimeducationid'] == tempValue['pimeducationid'] ){
            for(let value in data){
              if(item.hasOwnProperty(value)){
                  item[value] = data[value];
              }
            }
        }
    })
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(data);
    console.groupEnd();
    console.groupEnd();
    return [status, data];
});


    
// Save
mock.onPost(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimeducations\/([a-zA-Z0-9\-\;]{1,35})\/save$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: Save");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimeducationid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimeducations\/([a-zA-Z0-9\-\;]{1,35})\/save$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});
        
// Save
mock.onPost(new RegExp(/^\/pimeducations\/?([a-zA-Z0-9\-\;]{0,35})\/save$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: Save");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimeducationid'];
    const matchArray:any = new RegExp(/^\/pimeducations\/([a-zA-Z0-9\-\;]{1,35})\/save$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    //let items = mockDatas ? mockDatas : [];
    //let _items = items.find((item: any) => Object.is(item.pimeducationid, tempValue.pimeducationid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pimeducationid'] == tempValue['pimeducationid'] ){
            for(let value in data){
              if(item.hasOwnProperty(value)){
                  item[value] = data[value];
              }
            }
        }
    })
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(data);
    console.groupEnd();
    console.groupEnd();
    return [status, data];
});

    
// Create
mock.onPost(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimeducations\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: Create");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimeducationid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimeducations\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});
        
// Create
mock.onPost(new RegExp(/^\/pimeducations\/?([a-zA-Z0-9\-\;]{0,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: Create");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimeducationid'];
    const matchArray:any = new RegExp(/^\/pimeducations\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(mockDatas[0]);
    console.groupEnd();
    console.groupEnd();
    return [status, mockDatas[0]];
});


// GetDraft
mock.onGet(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimeducations\/getdraft$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: GetDraft");
    console.table({url:config.url, method: config.method, data:config.data});
    // GetDraft
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

// GetDraft
mock.onGet(new RegExp(/^\/pimeducations\/getdraft$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: GetDraft");
    console.table({url:config.url, method: config.method, data:config.data});
    // GetDraft
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

    
// CheckKey
mock.onPost(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimeducations\/([a-zA-Z0-9\-\;]{1,35})\/checkkey$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: CheckKey");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimeducationid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimeducations\/([a-zA-Z0-9\-\;]{1,35})\/checkkey$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});
        
// CheckKey
mock.onPost(new RegExp(/^\/pimeducations\/?([a-zA-Z0-9\-\;]{0,35})\/checkkey$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: CheckKey");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimeducationid'];
    const matchArray:any = new RegExp(/^\/pimeducations\/([a-zA-Z0-9\-\;]{1,35})\/checkkey$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    //let items = mockDatas ? mockDatas : [];
    //let _items = items.find((item: any) => Object.is(item.pimeducationid, tempValue.pimeducationid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pimeducationid'] == tempValue['pimeducationid'] ){
            for(let value in data){
              if(item.hasOwnProperty(value)){
                  item[value] = data[value];
              }
            }
        }
    })
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(data);
    console.groupEnd();
    console.groupEnd();
    return [status, data];
});


    
// Update
mock.onPut(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimeducations\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: Update");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimeducationid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimeducations\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});
        
// Update
mock.onPut(new RegExp(/^\/pimeducations\/?([a-zA-Z0-9\-\;]{0,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: Update");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimeducationid'];
    const matchArray:any = new RegExp(/^\/pimeducations\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    //let items = mockDatas ? mockDatas : [];
    //let _items = items.find((item: any) => Object.is(item.pimeducationid, tempValue.pimeducationid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pimeducationid'] == tempValue['pimeducationid'] ){
            for(let value in data){
              if(item.hasOwnProperty(value)){
                  item[value] = data[value];
              }
            }
        }
    })
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(data);
    console.groupEnd();
    console.groupEnd();
    return [status, data];
});


// FetchFAZZSY
mock.onGet(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimeducations\/fetchfazzsy$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: FetchFAZZSY");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimeducations\/fetchfazzsy$/).exec(config.url);
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    if (items.length > 0 && paramArray.length > 0) {
        paramArray.forEach((paramkey: any) => {
            if (tempValue[paramkey] && tempValue[paramkey].indexOf(";") > 0) {
                let keysGrounp: Array<any> = tempValue[paramkey].split(new RegExp(/[\;]/));
                let tempArray: Array<any> = [];
                keysGrounp.forEach((singlekey: any) => {
                    let _items =  items.filter((item: any) => { return item[paramkey] == singlekey });
                   if(_items.length >0){
                    tempArray.push(..._items);
                   }
                })
                items = tempArray;
            } else {
                items = items.filter((item: any) => { return item[paramkey] == tempValue[paramkey] });
            }
        })
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(items);
    console.groupEnd();
    console.groupEnd();
    return [status, items];
});
    
// FetchFAZZSY
mock.onGet(new RegExp(/^\/pimeducations\/fetchfazzsy$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: FetchFAZZSY");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(mockDatas);
    console.groupEnd();
    console.groupEnd();
    return [status, mockDatas ? mockDatas : []];
});

// FetchFAZZSY
mock.onGet(new RegExp(/^\/pimeducations\/fetchfazzsy(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: FetchFAZZSY");
    console.table({url:config.url, method: config.method, data:config.data});
    if(config.url.includes('page')){
        let url = config.url.split('?')[1];
        let params  =  qs.parse(url);
        Object.assign(config, params);
    }
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    let total = mockDatas.length;
    let records: Array<any> = [];
    if(!config.page || !config.size){
        records = mockDatas;
    }else{
        if((config.page-1)*config.size < total){
          records = mockDatas.slice(config.page,config.size);
        }
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(records ?  records : []);
    console.groupEnd();
    console.groupEnd();
    return [status, records ?  records : []];
});


// FetchJLSS
mock.onGet(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimeducations\/fetchjlss$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: FetchJLSS");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimeducations\/fetchjlss$/).exec(config.url);
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    if (items.length > 0 && paramArray.length > 0) {
        paramArray.forEach((paramkey: any) => {
            if (tempValue[paramkey] && tempValue[paramkey].indexOf(";") > 0) {
                let keysGrounp: Array<any> = tempValue[paramkey].split(new RegExp(/[\;]/));
                let tempArray: Array<any> = [];
                keysGrounp.forEach((singlekey: any) => {
                    let _items =  items.filter((item: any) => { return item[paramkey] == singlekey });
                   if(_items.length >0){
                    tempArray.push(..._items);
                   }
                })
                items = tempArray;
            } else {
                items = items.filter((item: any) => { return item[paramkey] == tempValue[paramkey] });
            }
        })
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(items);
    console.groupEnd();
    console.groupEnd();
    return [status, items];
});
    
// FetchJLSS
mock.onGet(new RegExp(/^\/pimeducations\/fetchjlss$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: FetchJLSS");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(mockDatas);
    console.groupEnd();
    console.groupEnd();
    return [status, mockDatas ? mockDatas : []];
});

// FetchJLSS
mock.onGet(new RegExp(/^\/pimeducations\/fetchjlss(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: FetchJLSS");
    console.table({url:config.url, method: config.method, data:config.data});
    if(config.url.includes('page')){
        let url = config.url.split('?')[1];
        let params  =  qs.parse(url);
        Object.assign(config, params);
    }
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    let total = mockDatas.length;
    let records: Array<any> = [];
    if(!config.page || !config.size){
        records = mockDatas;
    }else{
        if((config.page-1)*config.size < total){
          records = mockDatas.slice(config.page,config.size);
        }
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(records ?  records : []);
    console.groupEnd();
    console.groupEnd();
    return [status, records ?  records : []];
});


// FetchZIZHU
mock.onGet(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimeducations\/fetchzizhu$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: FetchZIZHU");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimeducations\/fetchzizhu$/).exec(config.url);
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    if (items.length > 0 && paramArray.length > 0) {
        paramArray.forEach((paramkey: any) => {
            if (tempValue[paramkey] && tempValue[paramkey].indexOf(";") > 0) {
                let keysGrounp: Array<any> = tempValue[paramkey].split(new RegExp(/[\;]/));
                let tempArray: Array<any> = [];
                keysGrounp.forEach((singlekey: any) => {
                    let _items =  items.filter((item: any) => { return item[paramkey] == singlekey });
                   if(_items.length >0){
                    tempArray.push(..._items);
                   }
                })
                items = tempArray;
            } else {
                items = items.filter((item: any) => { return item[paramkey] == tempValue[paramkey] });
            }
        })
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(items);
    console.groupEnd();
    console.groupEnd();
    return [status, items];
});
    
// FetchZIZHU
mock.onGet(new RegExp(/^\/pimeducations\/fetchzizhu$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: FetchZIZHU");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(mockDatas);
    console.groupEnd();
    console.groupEnd();
    return [status, mockDatas ? mockDatas : []];
});

// FetchZIZHU
mock.onGet(new RegExp(/^\/pimeducations\/fetchzizhu(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: FetchZIZHU");
    console.table({url:config.url, method: config.method, data:config.data});
    if(config.url.includes('page')){
        let url = config.url.split('?')[1];
        let params  =  qs.parse(url);
        Object.assign(config, params);
    }
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    let total = mockDatas.length;
    let records: Array<any> = [];
    if(!config.page || !config.size){
        records = mockDatas;
    }else{
        if((config.page-1)*config.size < total){
          records = mockDatas.slice(config.page,config.size);
        }
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(records ?  records : []);
    console.groupEnd();
    console.groupEnd();
    return [status, records ?  records : []];
});


// FetchADMDYZG
mock.onGet(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimeducations\/fetchadmdyzg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: FetchADMDYZG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimeducations\/fetchadmdyzg$/).exec(config.url);
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    if (items.length > 0 && paramArray.length > 0) {
        paramArray.forEach((paramkey: any) => {
            if (tempValue[paramkey] && tempValue[paramkey].indexOf(";") > 0) {
                let keysGrounp: Array<any> = tempValue[paramkey].split(new RegExp(/[\;]/));
                let tempArray: Array<any> = [];
                keysGrounp.forEach((singlekey: any) => {
                    let _items =  items.filter((item: any) => { return item[paramkey] == singlekey });
                   if(_items.length >0){
                    tempArray.push(..._items);
                   }
                })
                items = tempArray;
            } else {
                items = items.filter((item: any) => { return item[paramkey] == tempValue[paramkey] });
            }
        })
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(items);
    console.groupEnd();
    console.groupEnd();
    return [status, items];
});
    
// FetchADMDYZG
mock.onGet(new RegExp(/^\/pimeducations\/fetchadmdyzg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: FetchADMDYZG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(mockDatas);
    console.groupEnd();
    console.groupEnd();
    return [status, mockDatas ? mockDatas : []];
});

// FetchADMDYZG
mock.onGet(new RegExp(/^\/pimeducations\/fetchadmdyzg(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: FetchADMDYZG");
    console.table({url:config.url, method: config.method, data:config.data});
    if(config.url.includes('page')){
        let url = config.url.split('?')[1];
        let params  =  qs.parse(url);
        Object.assign(config, params);
    }
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    let total = mockDatas.length;
    let records: Array<any> = [];
    if(!config.page || !config.size){
        records = mockDatas;
    }else{
        if((config.page-1)*config.size < total){
          records = mockDatas.slice(config.page,config.size);
        }
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(records ?  records : []);
    console.groupEnd();
    console.groupEnd();
    return [status, records ?  records : []];
});


// FetchPERSONAL
mock.onGet(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimeducations\/fetchpersonal$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: FetchPERSONAL");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimeducations\/fetchpersonal$/).exec(config.url);
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    if (items.length > 0 && paramArray.length > 0) {
        paramArray.forEach((paramkey: any) => {
            if (tempValue[paramkey] && tempValue[paramkey].indexOf(";") > 0) {
                let keysGrounp: Array<any> = tempValue[paramkey].split(new RegExp(/[\;]/));
                let tempArray: Array<any> = [];
                keysGrounp.forEach((singlekey: any) => {
                    let _items =  items.filter((item: any) => { return item[paramkey] == singlekey });
                   if(_items.length >0){
                    tempArray.push(..._items);
                   }
                })
                items = tempArray;
            } else {
                items = items.filter((item: any) => { return item[paramkey] == tempValue[paramkey] });
            }
        })
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(items);
    console.groupEnd();
    console.groupEnd();
    return [status, items];
});
    
// FetchPERSONAL
mock.onGet(new RegExp(/^\/pimeducations\/fetchpersonal$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: FetchPERSONAL");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(mockDatas);
    console.groupEnd();
    console.groupEnd();
    return [status, mockDatas ? mockDatas : []];
});

// FetchPERSONAL
mock.onGet(new RegExp(/^\/pimeducations\/fetchpersonal(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: FetchPERSONAL");
    console.table({url:config.url, method: config.method, data:config.data});
    if(config.url.includes('page')){
        let url = config.url.split('?')[1];
        let params  =  qs.parse(url);
        Object.assign(config, params);
    }
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    let total = mockDatas.length;
    let records: Array<any> = [];
    if(!config.page || !config.size){
        records = mockDatas;
    }else{
        if((config.page-1)*config.size < total){
          records = mockDatas.slice(config.page,config.size);
        }
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(records ?  records : []);
    console.groupEnd();
    console.groupEnd();
    return [status, records ?  records : []];
});


// FetchADMSYSTEM
mock.onGet(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimeducations\/fetchadmsystem$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: FetchADMSYSTEM");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimeducations\/fetchadmsystem$/).exec(config.url);
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    if (items.length > 0 && paramArray.length > 0) {
        paramArray.forEach((paramkey: any) => {
            if (tempValue[paramkey] && tempValue[paramkey].indexOf(";") > 0) {
                let keysGrounp: Array<any> = tempValue[paramkey].split(new RegExp(/[\;]/));
                let tempArray: Array<any> = [];
                keysGrounp.forEach((singlekey: any) => {
                    let _items =  items.filter((item: any) => { return item[paramkey] == singlekey });
                   if(_items.length >0){
                    tempArray.push(..._items);
                   }
                })
                items = tempArray;
            } else {
                items = items.filter((item: any) => { return item[paramkey] == tempValue[paramkey] });
            }
        })
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(items);
    console.groupEnd();
    console.groupEnd();
    return [status, items];
});
    
// FetchADMSYSTEM
mock.onGet(new RegExp(/^\/pimeducations\/fetchadmsystem$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: FetchADMSYSTEM");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(mockDatas);
    console.groupEnd();
    console.groupEnd();
    return [status, mockDatas ? mockDatas : []];
});

// FetchADMSYSTEM
mock.onGet(new RegExp(/^\/pimeducations\/fetchadmsystem(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: FetchADMSYSTEM");
    console.table({url:config.url, method: config.method, data:config.data});
    if(config.url.includes('page')){
        let url = config.url.split('?')[1];
        let params  =  qs.parse(url);
        Object.assign(config, params);
    }
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    let total = mockDatas.length;
    let records: Array<any> = [];
    if(!config.page || !config.size){
        records = mockDatas;
    }else{
        if((config.page-1)*config.size < total){
          records = mockDatas.slice(config.page,config.size);
        }
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(records ?  records : []);
    console.groupEnd();
    console.groupEnd();
    return [status, records ?  records : []];
});


// FetchDefault
mock.onGet(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimeducations\/fetchdefault$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: FetchDefault");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimeducations\/fetchdefault$/).exec(config.url);
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    if (items.length > 0 && paramArray.length > 0) {
        paramArray.forEach((paramkey: any) => {
            if (tempValue[paramkey] && tempValue[paramkey].indexOf(";") > 0) {
                let keysGrounp: Array<any> = tempValue[paramkey].split(new RegExp(/[\;]/));
                let tempArray: Array<any> = [];
                keysGrounp.forEach((singlekey: any) => {
                    let _items =  items.filter((item: any) => { return item[paramkey] == singlekey });
                   if(_items.length >0){
                    tempArray.push(..._items);
                   }
                })
                items = tempArray;
            } else {
                items = items.filter((item: any) => { return item[paramkey] == tempValue[paramkey] });
            }
        })
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(items);
    console.groupEnd();
    console.groupEnd();
    return [status, items];
});
    
// FetchDefault
mock.onGet(new RegExp(/^\/pimeducations\/fetchdefault$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: FetchDefault");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(mockDatas);
    console.groupEnd();
    console.groupEnd();
    return [status, mockDatas ? mockDatas : []];
});

// FetchDefault
mock.onGet(new RegExp(/^\/pimeducations\/fetchdefault(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: FetchDefault");
    console.table({url:config.url, method: config.method, data:config.data});
    if(config.url.includes('page')){
        let url = config.url.split('?')[1];
        let params  =  qs.parse(url);
        Object.assign(config, params);
    }
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    let total = mockDatas.length;
    let records: Array<any> = [];
    if(!config.page || !config.size){
        records = mockDatas;
    }else{
        if((config.page-1)*config.size < total){
          records = mockDatas.slice(config.page,config.size);
        }
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(records ?  records : []);
    console.groupEnd();
    console.groupEnd();
    return [status, records ?  records : []];
});


// FetchREP_EDU
mock.onGet(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimeducations\/fetchrep_edu$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: FetchREP_EDU");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimeducations\/fetchrep_edu$/).exec(config.url);
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    if (items.length > 0 && paramArray.length > 0) {
        paramArray.forEach((paramkey: any) => {
            if (tempValue[paramkey] && tempValue[paramkey].indexOf(";") > 0) {
                let keysGrounp: Array<any> = tempValue[paramkey].split(new RegExp(/[\;]/));
                let tempArray: Array<any> = [];
                keysGrounp.forEach((singlekey: any) => {
                    let _items =  items.filter((item: any) => { return item[paramkey] == singlekey });
                   if(_items.length >0){
                    tempArray.push(..._items);
                   }
                })
                items = tempArray;
            } else {
                items = items.filter((item: any) => { return item[paramkey] == tempValue[paramkey] });
            }
        })
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(items);
    console.groupEnd();
    console.groupEnd();
    return [status, items];
});
    
// FetchREP_EDU
mock.onGet(new RegExp(/^\/pimeducations\/fetchrep_edu$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: FetchREP_EDU");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(mockDatas);
    console.groupEnd();
    console.groupEnd();
    return [status, mockDatas ? mockDatas : []];
});

// FetchREP_EDU
mock.onGet(new RegExp(/^\/pimeducations\/fetchrep_edu(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: FetchREP_EDU");
    console.table({url:config.url, method: config.method, data:config.data});
    if(config.url.includes('page')){
        let url = config.url.split('?')[1];
        let params  =  qs.parse(url);
        Object.assign(config, params);
    }
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    let total = mockDatas.length;
    let records: Array<any> = [];
    if(!config.page || !config.size){
        records = mockDatas;
    }else{
        if((config.page-1)*config.size < total){
          records = mockDatas.slice(config.page,config.size);
        }
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(records ?  records : []);
    console.groupEnd();
    console.groupEnd();
    return [status, records ?  records : []];
});

// URI参数传递情况未实现
// URI参数传递情况未实现

// URI参数传递情况未实现
// URI参数传递情况未实现

// URI参数传递情况未实现
// URI参数传递情况未实现

// URI参数传递情况未实现
// URI参数传递情况未实现

// URI参数传递情况未实现
// URI参数传递情况未实现

// URI参数传递情况未实现
// URI参数传递情况未实现

// URI参数传递情况未实现
// URI参数传递情况未实现


// Get
mock.onGet(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimeducations\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: Get");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimpersonid','pimeducationid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimeducations\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    let _items = items.find((item: any) => Object.is(item.pimeducationid, tempValue.pimeducationid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items?_items:{});
    console.groupEnd();
    console.groupEnd();
    return [status, _items?_items:{}];
});

// Get
mock.onGet(new RegExp(/^\/pimeducations\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: Get");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimeducationid'];
    const matchArray:any = new RegExp(/^\/pimeducations\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    let _items = items.find((item: any) => Object.is(item.pimeducationid, tempValue.pimeducationid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items?_items:{});
    console.groupEnd();
    console.groupEnd();
    return [status, _items?_items:{}];
});

// Remove
mock.onDelete(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimeducations\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: Remove");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimpersonid','pimeducationid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimeducations\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    let _items = items.find((item: any) => Object.is(item.pimeducationid, tempValue.pimeducationid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items?_items:{});
    console.groupEnd();
    console.groupEnd();
    return [status, _items?_items:{}];
});

// Remove
mock.onDelete(new RegExp(/^\/pimeducations\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimeducation 方法: Remove");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimeducationid'];
    const matchArray:any = new RegExp(/^\/pimeducations\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    let _items = items.find((item: any) => Object.is(item.pimeducationid, tempValue.pimeducationid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items?_items:{});
    console.groupEnd();
    console.groupEnd();
    return [status, _items?_items:{}];
});
