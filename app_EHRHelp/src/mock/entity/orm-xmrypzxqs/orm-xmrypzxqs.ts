import qs from 'qs';
import { MockAdapter } from '@/mock/mock-adapter';
const mock = MockAdapter.getInstance();

// 模拟数据
const mockDatas: Array<any> = [
];


//getwflink
mock.onGet(new RegExp(/^\/wfcore\/ehr-app-ehrhelp\/ormxmrypzxqs\/[a-zA-Z0-9\-\;]+\/usertasks\/[a-zA-Z0-9\-\;]+\/ways$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: getwflink");
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
mock.onGet(new RegExp(/^\/wfcore\/ehr-app-ehrhelp\/ormxmrypzxqs\/process-definitions-nodes$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: getwfstep");
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
mock.onPost(new RegExp(/^\/ormxmrypzxqs\/batch$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: createBatch");
    console.table({url:config.url, method: config.method, data:config.data});
    console.groupEnd();
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, {}];
    }
    return [status, {}];
});

// updateBatch
mock.onPut(new RegExp(/^\/ormxmrypzxqs\/batch$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: updateBatch");
    console.table({url:config.url, method: config.method, data:config.data});
    console.groupEnd();
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, {}];
    }
    return [status, {}];
});

// removeBatch
mock.onDelete(new RegExp(/^\/ormxmrypzxqs\/batch$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: removeBatch");
    console.table({url:config.url, method: config.method, data:config.data});
    console.groupEnd();
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, {}];
    }
    return [status, {}];
});


// Select
mock.onGet(new RegExp(/^\/ormxmrypzxqs\/([a-zA-Z0-9\-\;]{1,35})\/select$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: Select");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['ormxmrypzxqid'];
    const matchArray:any = new RegExp(/^\/ormxmrypzxqs\/([a-zA-Z0-9\-\;]{1,35})\/select$/).exec(config.url);
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
    let _items = items.find((item: any) => Object.is(item.ormxmrypzxqid, tempValue.ormxmrypzxqid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items);
    console.groupEnd();
    console.groupEnd();
    return [status, _items];
});

// GetDraft
mock.onGet(new RegExp(/^\/ormxmrypzxqs\/getdraft$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: GetDraft");
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
        
// SynTJ
mock.onPost(new RegExp(/^\/ormxmrypzxqs\/?([a-zA-Z0-9\-\;]{0,35})\/syntj$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: SynTJ");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['ormxmrypzxqid'];
    const matchArray:any = new RegExp(/^\/ormxmrypzxqs\/([a-zA-Z0-9\-\;]{1,35})\/syntj$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.ormxmrypzxqid, tempValue.ormxmrypzxqid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['ormxmrypzxqid'] == tempValue['ormxmrypzxqid'] ){
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
        
// MODSPTG
mock.onPost(new RegExp(/^\/ormxmrypzxqs\/?([a-zA-Z0-9\-\;]{0,35})\/modsptg$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: MODSPTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['ormxmrypzxqid'];
    const matchArray:any = new RegExp(/^\/ormxmrypzxqs\/([a-zA-Z0-9\-\;]{1,35})\/modsptg$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.ormxmrypzxqid, tempValue.ormxmrypzxqid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['ormxmrypzxqid'] == tempValue['ormxmrypzxqid'] ){
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
        
// CheckKey
mock.onPost(new RegExp(/^\/ormxmrypzxqs\/?([a-zA-Z0-9\-\;]{0,35})\/checkkey$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: CheckKey");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['ormxmrypzxqid'];
    const matchArray:any = new RegExp(/^\/ormxmrypzxqs\/([a-zA-Z0-9\-\;]{1,35})\/checkkey$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.ormxmrypzxqid, tempValue.ormxmrypzxqid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['ormxmrypzxqid'] == tempValue['ormxmrypzxqid'] ){
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
        
// SFBH
mock.onPost(new RegExp(/^\/ormxmrypzxqs\/?([a-zA-Z0-9\-\;]{0,35})\/sfbh$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: SFBH");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['ormxmrypzxqid'];
    const matchArray:any = new RegExp(/^\/ormxmrypzxqs\/([a-zA-Z0-9\-\;]{1,35})\/sfbh$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.ormxmrypzxqid, tempValue.ormxmrypzxqid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['ormxmrypzxqid'] == tempValue['ormxmrypzxqid'] ){
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
        
// Ensure
mock.onPost(new RegExp(/^\/ormxmrypzxqs\/?([a-zA-Z0-9\-\;]{0,35})\/ensure$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: Ensure");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['ormxmrypzxqid'];
    const matchArray:any = new RegExp(/^\/ormxmrypzxqs\/([a-zA-Z0-9\-\;]{1,35})\/ensure$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.ormxmrypzxqid, tempValue.ormxmrypzxqid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['ormxmrypzxqid'] == tempValue['ormxmrypzxqid'] ){
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
        
// SynDeployInfo
mock.onPost(new RegExp(/^\/ormxmrypzxqs\/?([a-zA-Z0-9\-\;]{0,35})\/syndeployinfo$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: SynDeployInfo");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['ormxmrypzxqid'];
    const matchArray:any = new RegExp(/^\/ormxmrypzxqs\/([a-zA-Z0-9\-\;]{1,35})\/syndeployinfo$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.ormxmrypzxqid, tempValue.ormxmrypzxqid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['ormxmrypzxqid'] == tempValue['ormxmrypzxqid'] ){
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
        
// MODBH
mock.onPost(new RegExp(/^\/ormxmrypzxqs\/?([a-zA-Z0-9\-\;]{0,35})\/modbh$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: MODBH");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['ormxmrypzxqid'];
    const matchArray:any = new RegExp(/^\/ormxmrypzxqs\/([a-zA-Z0-9\-\;]{1,35})\/modbh$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.ormxmrypzxqid, tempValue.ormxmrypzxqid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['ormxmrypzxqid'] == tempValue['ormxmrypzxqid'] ){
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
        
// SFQR
mock.onPost(new RegExp(/^\/ormxmrypzxqs\/?([a-zA-Z0-9\-\;]{0,35})\/sfqr$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: SFQR");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['ormxmrypzxqid'];
    const matchArray:any = new RegExp(/^\/ormxmrypzxqs\/([a-zA-Z0-9\-\;]{1,35})\/sfqr$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.ormxmrypzxqid, tempValue.ormxmrypzxqid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['ormxmrypzxqid'] == tempValue['ormxmrypzxqid'] ){
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
        
// SynPersonInfo
mock.onPost(new RegExp(/^\/ormxmrypzxqs\/?([a-zA-Z0-9\-\;]{0,35})\/synpersoninfo$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: SynPersonInfo");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['ormxmrypzxqid'];
    const matchArray:any = new RegExp(/^\/ormxmrypzxqs\/([a-zA-Z0-9\-\;]{1,35})\/synpersoninfo$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.ormxmrypzxqid, tempValue.ormxmrypzxqid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['ormxmrypzxqid'] == tempValue['ormxmrypzxqid'] ){
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
        
// SynRelease
mock.onPost(new RegExp(/^\/ormxmrypzxqs\/?([a-zA-Z0-9\-\;]{0,35})\/synrelease$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: SynRelease");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['ormxmrypzxqid'];
    const matchArray:any = new RegExp(/^\/ormxmrypzxqs\/([a-zA-Z0-9\-\;]{1,35})\/synrelease$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.ormxmrypzxqid, tempValue.ormxmrypzxqid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['ormxmrypzxqid'] == tempValue['ormxmrypzxqid'] ){
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
        
// SHTG
mock.onPost(new RegExp(/^\/ormxmrypzxqs\/?([a-zA-Z0-9\-\;]{0,35})\/shtg$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: SHTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['ormxmrypzxqid'];
    const matchArray:any = new RegExp(/^\/ormxmrypzxqs\/([a-zA-Z0-9\-\;]{1,35})\/shtg$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.ormxmrypzxqid, tempValue.ormxmrypzxqid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['ormxmrypzxqid'] == tempValue['ormxmrypzxqid'] ){
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
        
// TPSPTG
mock.onPost(new RegExp(/^\/ormxmrypzxqs\/?([a-zA-Z0-9\-\;]{0,35})\/tpsptg$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: TPSPTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['ormxmrypzxqid'];
    const matchArray:any = new RegExp(/^\/ormxmrypzxqs\/([a-zA-Z0-9\-\;]{1,35})\/tpsptg$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.ormxmrypzxqid, tempValue.ormxmrypzxqid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['ormxmrypzxqid'] == tempValue['ormxmrypzxqid'] ){
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
        
// BH
mock.onPost(new RegExp(/^\/ormxmrypzxqs\/?([a-zA-Z0-9\-\;]{0,35})\/bh$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: BH");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['ormxmrypzxqid'];
    const matchArray:any = new RegExp(/^\/ormxmrypzxqs\/([a-zA-Z0-9\-\;]{1,35})\/bh$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.ormxmrypzxqid, tempValue.ormxmrypzxqid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['ormxmrypzxqid'] == tempValue['ormxmrypzxqid'] ){
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
mock.onPost(new RegExp(/^\/ormxmrypzxqs\/?([a-zA-Z0-9\-\;]{0,35})\/save$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: Save");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['ormxmrypzxqid'];
    const matchArray:any = new RegExp(/^\/ormxmrypzxqs\/([a-zA-Z0-9\-\;]{1,35})\/save$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.ormxmrypzxqid, tempValue.ormxmrypzxqid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['ormxmrypzxqid'] == tempValue['ormxmrypzxqid'] ){
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
        
// SFSPTG
mock.onPost(new RegExp(/^\/ormxmrypzxqs\/?([a-zA-Z0-9\-\;]{0,35})\/sfsptg$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: SFSPTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['ormxmrypzxqid'];
    const matchArray:any = new RegExp(/^\/ormxmrypzxqs\/([a-zA-Z0-9\-\;]{1,35})\/sfsptg$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.ormxmrypzxqid, tempValue.ormxmrypzxqid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['ormxmrypzxqid'] == tempValue['ormxmrypzxqid'] ){
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
        
// TPBH
mock.onPost(new RegExp(/^\/ormxmrypzxqs\/?([a-zA-Z0-9\-\;]{0,35})\/tpbh$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: TPBH");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['ormxmrypzxqid'];
    const matchArray:any = new RegExp(/^\/ormxmrypzxqs\/([a-zA-Z0-9\-\;]{1,35})\/tpbh$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.ormxmrypzxqid, tempValue.ormxmrypzxqid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['ormxmrypzxqid'] == tempValue['ormxmrypzxqid'] ){
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
        
// TPQR
mock.onPost(new RegExp(/^\/ormxmrypzxqs\/?([a-zA-Z0-9\-\;]{0,35})\/tpqr$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: TPQR");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['ormxmrypzxqid'];
    const matchArray:any = new RegExp(/^\/ormxmrypzxqs\/([a-zA-Z0-9\-\;]{1,35})\/tpqr$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.ormxmrypzxqid, tempValue.ormxmrypzxqid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['ormxmrypzxqid'] == tempValue['ormxmrypzxqid'] ){
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
mock.onPost(new RegExp(/^\/ormxmrypzxqs\/?([a-zA-Z0-9\-\;]{0,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: Create");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['ormxmrypzxqid'];
    const matchArray:any = new RegExp(/^\/ormxmrypzxqs\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
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
        
// Update
mock.onPut(new RegExp(/^\/ormxmrypzxqs\/?([a-zA-Z0-9\-\;]{0,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: Update");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['ormxmrypzxqid'];
    const matchArray:any = new RegExp(/^\/ormxmrypzxqs\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.ormxmrypzxqid, tempValue.ormxmrypzxqid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['ormxmrypzxqid'] == tempValue['ormxmrypzxqid'] ){
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
    
// FetchRSSH
mock.onGet(new RegExp(/^\/ormxmrypzxqs\/fetchrssh$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: FetchRSSH");
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

// FetchRSSH
mock.onGet(new RegExp(/^\/ormxmrypzxqs\/fetchrssh(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: FetchRSSH");
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
    
// FetchCURFQTP
mock.onGet(new RegExp(/^\/ormxmrypzxqs\/fetchcurfqtp$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: FetchCURFQTP");
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

// FetchCURFQTP
mock.onGet(new RegExp(/^\/ormxmrypzxqs\/fetchcurfqtp(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: FetchCURFQTP");
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
    
// FetchCXSJ
mock.onGet(new RegExp(/^\/ormxmrypzxqs\/fetchcxsj$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: FetchCXSJ");
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

// FetchCXSJ
mock.onGet(new RegExp(/^\/ormxmrypzxqs\/fetchcxsj(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: FetchCXSJ");
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
    
// FetchKZXMQX
mock.onGet(new RegExp(/^\/ormxmrypzxqs\/fetchkzxmqx$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: FetchKZXMQX");
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

// FetchKZXMQX
mock.onGet(new RegExp(/^\/ormxmrypzxqs\/fetchkzxmqx(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: FetchKZXMQX");
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
    
// FetchSFSH
mock.onGet(new RegExp(/^\/ormxmrypzxqs\/fetchsfsh$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: FetchSFSH");
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

// FetchSFSH
mock.onGet(new RegExp(/^\/ormxmrypzxqs\/fetchsfsh(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: FetchSFSH");
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
    
// FetchCURFQSF
mock.onGet(new RegExp(/^\/ormxmrypzxqs\/fetchcurfqsf$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: FetchCURFQSF");
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

// FetchCURFQSF
mock.onGet(new RegExp(/^\/ormxmrypzxqs\/fetchcurfqsf(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: FetchCURFQSF");
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
    
// FetchTPSH
mock.onGet(new RegExp(/^\/ormxmrypzxqs\/fetchtpsh$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: FetchTPSH");
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

// FetchTPSH
mock.onGet(new RegExp(/^\/ormxmrypzxqs\/fetchtpsh(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: FetchTPSH");
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
    
// FetchSFCXSJ
mock.onGet(new RegExp(/^\/ormxmrypzxqs\/fetchsfcxsj$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: FetchSFCXSJ");
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

// FetchSFCXSJ
mock.onGet(new RegExp(/^\/ormxmrypzxqs\/fetchsfcxsj(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: FetchSFCXSJ");
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
    
// FetchMODSPSH
mock.onGet(new RegExp(/^\/ormxmrypzxqs\/fetchmodspsh$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: FetchMODSPSH");
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

// FetchMODSPSH
mock.onGet(new RegExp(/^\/ormxmrypzxqs\/fetchmodspsh(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: FetchMODSPSH");
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
mock.onGet(new RegExp(/^\/ormxmrypzxqs\/fetchdefault$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: FetchDefault");
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
mock.onGet(new RegExp(/^\/ormxmrypzxqs\/fetchdefault(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: FetchDefault");
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
    
// FetchXMCBMX
mock.onGet(new RegExp(/^\/ormxmrypzxqs\/fetchxmcbmx$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: FetchXMCBMX");
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

// FetchXMCBMX
mock.onGet(new RegExp(/^\/ormxmrypzxqs\/fetchxmcbmx(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: FetchXMCBMX");
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


// Get
mock.onGet(new RegExp(/^\/ormxmrypzxqs\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: Get");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['ormxmrypzxqid'];
    const matchArray:any = new RegExp(/^\/ormxmrypzxqs\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
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
    let _items = items.find((item: any) => Object.is(item.ormxmrypzxqid, tempValue.ormxmrypzxqid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items?_items:{});
    console.groupEnd();
    console.groupEnd();
    return [status, _items?_items:{}];
});

// Remove
mock.onDelete(new RegExp(/^\/ormxmrypzxqs\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:ormxmrypzxq 方法: Remove");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['ormxmrypzxqid'];
    const matchArray:any = new RegExp(/^\/ormxmrypzxqs\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
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
    let _items = items.find((item: any) => Object.is(item.ormxmrypzxqid, tempValue.ormxmrypzxqid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items?_items:{});
    console.groupEnd();
    console.groupEnd();
    return [status, _items?_items:{}];
});
