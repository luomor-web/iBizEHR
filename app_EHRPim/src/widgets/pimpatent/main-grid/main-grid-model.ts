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
          name: 'jlczz',
          prop: 'jlczz',
          dataType: 'TEXT',
        },
        {
          name: 'zlhqsj',
          prop: 'zlhqsj',
          dataType: 'DATE',
        },
        {
          name: 'zlh',
          prop: 'zlh',
          dataType: 'TEXT',
        },
        {
          name: 'pimpatentname',
          prop: 'pimpatentname',
          dataType: 'TEXT',
        },
        {
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'zlpzgb',
          prop: 'zlpzgb',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'pimpatentname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pimpatentid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pimpatentid',
          dataType: 'GUID',
        },
        {
          name: 'enclolure',
          prop: 'enclolure',
          dataType: 'LONGTEXT_1000',
        },
        {
          name: 'pimpatent',
          prop: 'pimpatentid',
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