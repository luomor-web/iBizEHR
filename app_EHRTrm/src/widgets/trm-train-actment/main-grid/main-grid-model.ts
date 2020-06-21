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
          name: 'evalcontents',
          prop: 'evalcontents',
          dataType: 'TEXT',
        },
        {
          name: 'dcwjtm',
          prop: 'dcwjtm',
          dataType: 'TEXT',
        },
        {
          name: 'evaltime',
          prop: 'evaltime',
          dataType: 'DATE',
        },
        {
          name: 'trmtrainactapplyid',
          prop: 'trmtrainactapplyid',
          dataType: 'PICKUP',
        },
        {
          name: 'bz',
          prop: 'bz',
          dataType: 'LONGTEXT_1000',
        },
        {
          name: 'pxjg',
          prop: 'pxjg',
          dataType: 'SSCODELIST',
        },
        {
          name: 'srfmajortext',
          prop: 'trmtrainactmentname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'trmtrainactmentid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'trmtrainactmentid',
          dataType: 'GUID',
        },
        {
          name: 'evaltarget',
          prop: 'evaltarget',
          dataType: 'SSCODELIST',
        },
        {
          name: 'trmtrainactment',
          prop: 'trmtrainactmentid',
        },
      {
        name: 'n_trmtrainactapplyname_eq',
        prop: 'n_trmtrainactapplyname_eq',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_trmtrainactapplyid_eq',
        prop: 'n_trmtrainactapplyid_eq',
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