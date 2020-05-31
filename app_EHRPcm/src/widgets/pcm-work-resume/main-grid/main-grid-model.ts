/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof MainGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof MainGridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'zw',
          prop: 'zw',
          dataType: 'TEXT',
        },
        {
          name: 'resumecontent',
          prop: 'resumecontent',
          dataType: 'TEXT',
        },
        {
          name: 'gw',
          prop: 'gw',
          dataType: 'TEXT',
        },
        {
          name: 'bm',
          prop: 'bm',
          dataType: 'TEXT',
        },
        {
          name: 'servebegintime',
          prop: 'servebegintime',
          dataType: 'DATE',
        },
        {
          name: 'workunit',
          prop: 'workunit',
          dataType: 'TEXT',
        },
        {
          name: 'serveendtime',
          prop: 'serveendtime',
          dataType: 'DATE',
        },
        {
          name: 'pcmprofileid',
          prop: 'pcmprofileid',
          dataType: 'PICKUP',
        },
        {
          name: 'srfmajortext',
          prop: 'pcmworkresumename',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pcmworkresumeid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pcmworkresumeid',
          dataType: 'GUID',
        },
        {
          name: 'pcmworkresume',
          prop: 'pcmworkresumeid',
        },

        {
          name:'size',
          prop:'size'
        },
        {
          name:'query',
          prop:'query'
        },
        {
          name:'page',
          prop:'page'
        },
        {
          name:'sort',
          prop:'sort'
        },
        {
          name:'srfparentdata',
          prop:'srfparentdata'
        },
        // 前端新增修改标识，新增为"0",修改为"1"或未设值
        {
          name: 'srffrontuf',
          prop: 'srffrontuf',
          dataType: 'TEXT',
        },
      ]
    }
  }

}