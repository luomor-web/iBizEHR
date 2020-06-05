/**
 * SYQYGSearchForm 部件模型
 *
 * @export
 * @class SYQYGSearchFormModel
 */
export default class SYQYGSearchFormModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof SYQYGSearchFormModel
  */
  public getDataItems(): any[] {
    return [
      {
        name: 'srfwfmemo',
        prop: 'srfwfmemo',
        dataType: 'TEXT',
      },
      // 前端新增修改标识，新增为"0",修改为"1"或未设值
      {
        name: 'srffrontuf',
        prop: 'srffrontuf',
        dataType: 'TEXT',
      },
      {
        name: 'n_pimpersonname_like',
        prop: 'pimpersonname',
        dataType: 'TEXT',
      },
      {
        name: 'n_ygbh_like',
        prop: 'ygbh',
        dataType: 'TEXT',
      },
      {
        name: 'n_ormorgname_like',
        prop: 'ormorgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_ormorgsectorname_like',
        prop: 'ormorgsectorname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_gw_eq',
        prop: 'gw',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_duration_eq',
        prop: 'duration',
        dataType: 'TEXT',
      },
      {
        name: 'n_sydq_ltandeq',
        prop: 'sydq',
        dataType: 'DATE',
      },
      {
        name: 'n_rzqd_eq',
        prop: 'rzqd',
        dataType: 'SSCODELIST',
      },
    ]
  }

}