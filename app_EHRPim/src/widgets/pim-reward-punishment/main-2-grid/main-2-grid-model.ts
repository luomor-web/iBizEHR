/**
 * Main_2 部件模型
 *
 * @export
 * @class Main_2Model
 */
export default class Main_2Model {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof Main_2GridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof Main_2GridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'pimrewardpunishmentname',
          prop: 'pimrewardpunishmentname',
          dataType: 'TEXT',
        },
        {
          name: 'department',
          prop: 'department',
          dataType: 'TEXT',
        },
        {
          name: 'jlsj',
          prop: 'jlsj',
          dataType: 'DATE',
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