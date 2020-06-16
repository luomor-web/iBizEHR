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
          name: 'xj',
          prop: 'xj',
          dataType: 'TEXT',
        },
        {
          name: 'trmtrainaddressname',
          prop: 'trmtrainaddressname',
          dataType: 'TEXT',
        },
        {
          name: 'ormorgid',
          prop: 'ormorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'dz',
          prop: 'dz',
          dataType: 'TEXT',
        },
        {
          name: 'sf',
          prop: 'sf',
          dataType: 'SSCODELIST',
        },
        {
          name: 'xz',
          prop: 'xz',
          dataType: 'SSCODELIST',
        },
        {
          name: 'srfmajortext',
          prop: 'trmtrainaddressname',
          dataType: 'TEXT',
        },
        {
          name: 'srfkey',
          prop: 'trmtrainaddressid',
          dataType: 'GUID',
        },
        {
          name: 'srfdataaccaction',
          prop: 'trmtrainaddressid',
          dataType: 'GUID',
        },
        {
          name: 'lxr',
          prop: 'lxr',
          dataType: 'TEXT',
        },
        {
          name: 's',
          prop: 's',
          dataType: 'TEXT',
        },
        {
          name: 'hjzk',
          prop: 'hjzk',
          dataType: 'SSCODELIST',
        },
        {
          name: 'lxdh',
          prop: 'lxdh',
          dataType: 'TEXT',
        },
        {
          name: 'shortname',
          prop: 'shortname',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'trmtrainaddress',
          prop: 'trmtrainaddressid',
        },
      {
        name: 'n_trmtrainaddressname_like',
        prop: 'n_trmtrainaddressname_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_s_eq',
        prop: 'n_s_eq',
        dataType: 'TEXT',
      },
      {
        name: 'n_sf_eq',
        prop: 'n_sf_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_hjzk_eq',
        prop: 'n_hjzk_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_pxlx_eq',
        prop: 'n_pxlx_eq',
        dataType: 'SSCODELIST',
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