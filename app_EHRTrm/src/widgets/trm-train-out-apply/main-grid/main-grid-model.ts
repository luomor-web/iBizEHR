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
          name: 'pxlb',
          prop: 'pxlb',
          dataType: 'TEXT',
        },
        {
          name: 'pxjsrq',
          prop: 'pxjsrq',
          dataType: 'DATE',
        },
        {
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'zz',
          prop: 'zz',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'pxdd',
          prop: 'pxdd',
          dataType: 'TEXT',
        },
        {
          name: 'pxmb',
          prop: 'pxmb',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'trmtrainoutapplyname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'trmtrainoutapplyid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'trmtrainoutapplyid',
          dataType: 'GUID',
        },
        {
          name: 'pxksrq',
          prop: 'pxksrq',
          dataType: 'DATE',
        },
        {
          name: 'pxfs',
          prop: 'pxfs',
          dataType: 'TEXT',
        },
        {
          name: 'pxnr',
          prop: 'pxnr',
          dataType: 'TEXT',
        },
        {
          name: 'pimpersonname',
          prop: 'pimpersonname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'djbh',
          prop: 'djbh',
          dataType: 'TEXT',
        },
        {
          name: 'trmtrainoutapplyname',
          prop: 'trmtrainoutapplyname',
          dataType: 'TEXT',
        },
        {
          name: 'trmtrainoutapply',
          prop: 'trmtrainoutapplyid',
        },
      {
        name: 'n_trmtrainoutapplyname_like',
        prop: 'n_trmtrainoutapplyname_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_pxfs_eq',
        prop: 'n_pxfs_eq',
        dataType: 'TEXT',
      },
      {
        name: 'n_pxlb_eq',
        prop: 'n_pxlb_eq',
        dataType: 'TEXT',
      },
      {
        name: 'n_ywlx_eq',
        prop: 'n_ywlx_eq',
        dataType: 'TEXT',
      },
      {
        name: 'n_wbpxjg_eq',
        prop: 'n_wbpxjg_eq',
        dataType: 'TEXT',
      },
      {
        name: 'n_pimpersonname_like',
        prop: 'n_pimpersonname_like',
        dataType: 'PICKUPTEXT',
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