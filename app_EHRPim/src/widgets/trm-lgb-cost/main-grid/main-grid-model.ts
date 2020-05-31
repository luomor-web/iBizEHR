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
          name: 'hdsm',
          prop: 'hdsm',
          dataType: 'LONGTEXT_1000',
        },
        {
          name: 'je',
          prop: 'je',
          dataType: 'FLOAT',
        },
        {
          name: 'ormorgid',
          prop: 'ormorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'jssj',
          prop: 'jssj',
          dataType: 'DATE',
        },
        {
          name: 'kssj',
          prop: 'kssj',
          dataType: 'DATE',
        },
        {
          name: 'srfmajortext',
          prop: 'trmlgbcostname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'trmlgbcostid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'trmlgbcostid',
          dataType: 'GUID',
        },
        {
          name: 'trmlgbcostname',
          prop: 'trmlgbcostname',
          dataType: 'TEXT',
        },
        {
          name: 'trmlgbcost',
          prop: 'trmlgbcostid',
        },
      {
        name: 'n_trmlgbcostname_like',
        prop: 'n_trmlgbcostname_like',
        dataType: 'TEXT',
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