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
          dataType: 'SSCODELIST',
        },
        {
          name: 'ormorgsectorid',
          prop: 'ormorgsectorid',
          dataType: 'PICKUP',
        },
        {
          name: 'pxyf',
          prop: 'pxyf',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pxnd',
          prop: 'pxnd',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pxmb',
          prop: 'pxmb',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'trmtrainactapplyname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'trmtrainactapplyid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'trmtrainactapplyid',
          dataType: 'GUID',
        },
        {
          name: 'trmtrainactapplyname',
          prop: 'trmtrainactapplyname',
          dataType: 'TEXT',
        },
        {
          name: 'ormorgsectorname',
          prop: 'ormorgsectorname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'pxfs',
          prop: 'pxfs',
          dataType: 'SSCODELIST',
        },
        {
          name: 'jhpxrs',
          prop: 'jhpxrs',
          dataType: 'INT',
        },
        {
          name: 'pxnr',
          prop: 'pxnr',
          dataType: 'TEXT',
        },
        {
          name: 'sjpxrs',
          prop: 'sjpxrs',
          dataType: 'INT',
        },
        {
          name: 'pxhdbm',
          prop: 'pxhdbm',
          dataType: 'TEXT',
        },
        {
          name: 'pxjd',
          prop: 'pxjd',
          dataType: 'SSCODELIST',
        },
        {
          name: 'trmtrainactapply',
          prop: 'trmtrainactapplyid',
        },
      {
        name: 'n_ormorgsectorname_eq',
        prop: 'n_ormorgsectorname_eq',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_pxdxlb_eq',
        prop: 'n_pxdxlb_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_pxfs_eq',
        prop: 'n_pxfs_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_pxjb_eq',
        prop: 'n_pxjb_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_pxlb_eq',
        prop: 'n_pxlb_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_pxnd_eq',
        prop: 'n_pxnd_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_pxjd_eq',
        prop: 'n_pxjd_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_pxyf_eq',
        prop: 'n_pxyf_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_ormorgsectorid_eq',
        prop: 'n_ormorgsectorid_eq',
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