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
          name: 'khjl',
          prop: 'khjl',
          dataType: 'SSCODELIST',
        },
        {
          name: 'jd',
          prop: 'jd',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'yd',
          prop: 'yd',
          dataType: 'SSCODELIST',
        },
        {
          name: 'khlx',
          prop: 'khlx',
          dataType: 'SSCODELIST',
        },
        {
          name: 'khjl_text',
          prop: 'khjl',
          dataType: 'SSCODELIST',
        },
        {
          name: 'evaluationunit',
          prop: 'evaluationunit',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'pimachievementsname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pimachievementsid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pimachievementsid',
          dataType: 'GUID',
        },
        {
          name: 'pimachievementsname',
          prop: 'pimachievementsname',
          dataType: 'TEXT',
        },
        {
          name: 'pimachievements',
          prop: 'pimachievementsid',
        },
      {
        name: 'n_pimpersonname_like',
        prop: 'n_pimpersonname_like',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_khjl_eq',
        prop: 'n_khjl_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_xmjb_eq',
        prop: 'n_xmjb_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_dj_eq',
        prop: 'n_dj_eq',
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