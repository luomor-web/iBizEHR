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
          name: 'grzlwzzzdpm',
          prop: 'grzlwzzzdpm',
          dataType: 'INT',
        },
        {
          name: 'jlczz',
          prop: 'jlczz',
          dataType: 'TEXT',
        },
        {
          name: 'fj',
          prop: 'fj',
          dataType: 'LONGTEXT_1000',
        },
        {
          name: 'kwmc',
          prop: 'kwmc',
          dataType: 'TEXT',
        },
        {
          name: 'cbs',
          prop: 'cbs',
          dataType: 'TEXT',
        },
        {
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'kwqs',
          prop: 'kwqs',
          dataType: 'INT',
        },
        {
          name: 'pimpapername',
          prop: 'pimpapername',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'pimpapername',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pimpaperid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pimpaperid',
          dataType: 'GUID',
        },
        {
          name: 'fbsj',
          prop: 'fbsj',
          dataType: 'DATE',
        },
        {
          name: 'pimpaper',
          prop: 'pimpaperid',
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