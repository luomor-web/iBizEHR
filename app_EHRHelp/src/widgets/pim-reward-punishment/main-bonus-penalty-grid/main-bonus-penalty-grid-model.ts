/**
 * Main_BonusPenalty 部件模型
 *
 * @export
 * @class Main_BonusPenaltyModel
 */
export default class Main_BonusPenaltyModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof Main_BonusPenaltyGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof Main_BonusPenaltyGridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'jlspzt',
          prop: 'jlspzt',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'jlsj',
          prop: 'jlsj',
          dataType: 'DATE',
        },
        {
          name: 'jcsj',
          prop: 'jcsj',
          dataType: 'LONGTEXT_1000',
        },
        {
          name: 'jcjb',
          prop: 'jcjb',
          dataType: 'SSCODELIST',
        },
        {
          name: 'srfmajortext',
          prop: 'pimrewardpunishmentname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pimrewardpunishmentid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pimrewardpunishmentid',
          dataType: 'GUID',
        },
        {
          name: 'lx',
          prop: 'lx',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pimrewardpunishment',
          prop: 'pimrewardpunishmentid',
        },
      {
        name: 'n_pimpersonname_like',
        prop: 'n_pimpersonname_like',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_lx_eq',
        prop: 'n_lx_eq',
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