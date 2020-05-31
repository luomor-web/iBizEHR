/**
 * Main_Family 部件模型
 *
 * @export
 * @class Main_FamilyModel
 */
export default class Main_FamilyModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof Main_FamilyGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof Main_FamilyGridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'gzdw',
          prop: 'gzdw',
          dataType: 'TEXT',
        },
        {
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'srfmajortext',
          prop: 'pimfaminfoname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pimfaminfoid',
          dataType: 'GUID',
        },
        {
          name: 'sfjjllr',
          prop: 'sfjjllr',
          dataType: 'SSCODELIST',
        },
        {
          name: 'srfkey',
          prop: 'pimfaminfoid',
          dataType: 'GUID',
        },
        {
          name: 'pimfaminfoname',
          prop: 'pimfaminfoname',
          dataType: 'TEXT',
        },
        {
          name: 'zw',
          prop: 'zw',
          dataType: 'TEXT',
        },
        {
          name: 'jlspzt',
          prop: 'jlspzt',
          dataType: 'TEXT',
        },
        {
          name: 'xb',
          prop: 'xb',
          dataType: 'SSCODELIST',
        },
        {
          name: 'zjh',
          prop: 'zjh',
          dataType: 'TEXT',
        },
        {
          name: 'csrq',
          prop: 'csrq',
          dataType: 'DATE',
        },
        {
          name: 'ybrgx',
          prop: 'ybrgx',
          dataType: 'SSCODELIST',
        },
        {
          name: 'nl',
          prop: 'nl',
          dataType: 'INT',
        },
        {
          name: 'zzmm',
          prop: 'zzmm',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pimfaminfo',
          prop: 'pimfaminfoid',
        },
      {
        name: 'n_pimfaminfoname_like',
        prop: 'n_pimfaminfoname_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_xb_eq',
        prop: 'n_xb_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_zzmm_eq',
        prop: 'n_zzmm_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_sfjjllr_eq',
        prop: 'n_sfjjllr_eq',
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