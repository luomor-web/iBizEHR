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
          name: 'pimenclosurename',
          prop: 'pimenclosurename',
          dataType: 'TEXT',
        },
        {
          name: 'fjfl',
          prop: 'fjfl',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'fjkz',
          prop: 'fjkz',
          dataType: 'LONGTEXT_1000',
        },
        {
          name: 'updateman',
          prop: 'updateman',
          dataType: 'TEXT',
        },
        {
          name: 'updatedate',
          prop: 'updatedate',
          dataType: 'DATE',
        },
        {
          name: 'srfmajortext',
          prop: 'pimenclosurename',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pimenclosureid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pimenclosureid',
          dataType: 'GUID',
        },
        {
          name: 'pimenclosure',
          prop: 'pimenclosureid',
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