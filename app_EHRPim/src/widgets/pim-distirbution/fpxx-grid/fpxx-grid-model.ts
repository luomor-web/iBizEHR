/**
 * FPXX 部件模型
 *
 * @export
 * @class FPXXModel
 */
export default class FPXXModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof FPXXGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof FPXXGridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'fplx',
          prop: 'fplx',
          dataType: 'SSCODELIST',
        },
        {
          name: 'ormpostid',
          prop: 'ormpostid',
          dataType: 'PICKUP',
        },
        {
          name: 'ormorgsectorid',
          prop: 'ormorgsectorid',
          dataType: 'PICKUP',
        },
        {
          name: 'ormpostname',
          prop: 'ormpostname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'rzkssj',
          prop: 'rzkssj',
          dataType: 'DATE',
        },
        {
          name: 'cfplx',
          prop: 'cfplx',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'ormorgid',
          prop: 'ormorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'fplx_text',
          prop: 'fplx',
          dataType: 'SSCODELIST',
        },
        {
          name: 'srfmajortext',
          prop: 'pimpersonname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'ormdutyname',
          prop: 'ormdutyname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'srfkey',
          prop: 'pimdistirbutionid',
          dataType: 'GUID',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pimdistirbutionid',
          dataType: 'GUID',
        },
        {
          name: 'yzzid',
          prop: 'yzzid',
          dataType: 'PICKUP',
        },
        {
          name: 'ormdutyid',
          prop: 'ormdutyid',
          dataType: 'PICKUP',
        },
        {
          name: 'zzdzs',
          prop: 'zzdzs',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'ormpostid1',
          prop: 'ormpostid1',
          dataType: 'PICKUP',
        },
        {
          name: 'ybmid',
          prop: 'ybmid',
          dataType: 'PICKUP',
        },
        {
          name: 'shortname',
          prop: 'shortname',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'rzjssj',
          prop: 'rzjssj',
          dataType: 'DATE',
        },
        {
          name: 'pimdistirbution',
          prop: 'pimdistirbutionid',
        },
      {
        name: 'n_ygbh_like',
        prop: 'n_ygbh_like',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'n_pimpersonname_like',
        prop: 'n_pimpersonname_like',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_ormorgname_eq',
        prop: 'n_ormorgname_eq',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_ormorgsectorname_eq',
        prop: 'n_ormorgsectorname_eq',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_ormdutyname_eq',
        prop: 'n_ormdutyname_eq',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_ormpostname_eq',
        prop: 'n_ormpostname_eq',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_fplx_eq',
        prop: 'n_fplx_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_cfplx_eq',
        prop: 'n_cfplx_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_fpzt_eq',
        prop: 'n_fpzt_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_ormpostid_eq',
        prop: 'n_ormpostid_eq',
      },
      {
        name: 'n_ormorgid_eq',
        prop: 'n_ormorgid_eq',
      },
      {
        name: 'n_ormdutyid_eq',
        prop: 'n_ormdutyid_eq',
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