/**
 * TXRYSearchForm 部件模型
 *
 * @export
 * @class TXRYSearchFormModel
 */
export default class TXRYSearchFormModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof TXRYSearchFormModel
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
        name: 'n_ygbh_like',
        prop: 'ygbh',
        dataType: 'TEXT',
      },
      {
        name: 'n_pimpersonname_like',
        prop: 'pimpersonname',
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
        name: 'n_sjtxrq_gtandeq',
        prop: 'sjtxrq',
        dataType: 'DATE',
      },
      {
        name: 'n_sjtxrq_ltandeq',
        prop: 'sjtxrq',
        dataType: 'DATE',
      },
    ]
  }

}