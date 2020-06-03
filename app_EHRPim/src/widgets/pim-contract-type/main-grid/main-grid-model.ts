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
          name: 'ormorgid',
          prop: 'ormorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'pimcontracttypename',
          prop: 'pimcontracttypename',
          dataType: 'TEXT',
        },
        {
          name: 'sbm',
          prop: 'sbm',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'pimcontracttypename',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pimcontracttypeid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pimcontracttypeid',
          dataType: 'GUID',
        },
        {
          name: 'pimcontracttype',
          prop: 'pimcontracttypeid',
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