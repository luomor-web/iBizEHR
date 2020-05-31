/**
 * Default 部件模型
 *
 * @export
 * @class DefaultModel
 */
export default class DefaultModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof DefaultModel
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
        dataType: 'PICKUPDATA',
      },
      {
        name: 'n_pimpersonname_like',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_ygzt_eq',
        prop: 'ygzt',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'n_htbh_like',
        prop: 'htbh',
        dataType: 'TEXT',
      },
      {
        name: 'n_htlx_eq',
        prop: 'htlx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_htzt_eq',
        prop: 'htzt',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_qsrq_gtandeq',
        prop: 'qsrq',
        dataType: 'DATE',
      },
      {
        name: 'n_jsrq_ltandeq',
        prop: 'jsrq',
        dataType: 'DATE',
      },
      {
        name: 'n_contracttype_eq',
        prop: 'contracttype',
        dataType: 'SSCODELIST',
      },
    ]
  }

}