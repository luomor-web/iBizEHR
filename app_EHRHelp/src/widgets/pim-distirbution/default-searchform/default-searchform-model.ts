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
        name: 'n_ormorgname_eq',
        prop: 'ormorgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_ormorgsectorname_eq',
        prop: 'ormorgsectorname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_ormdutyname_eq',
        prop: 'ormdutyname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_ormpostname_eq',
        prop: 'ormpostname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_fplx_eq',
        prop: 'fplx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_cfplx_eq',
        prop: 'cfplx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_fpzt_eq',
        prop: 'fpzt',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_ormpostid_eq',
      },
      {
        name: 'n_ormorgid_eq',
      },
      {
        name: 'n_ormdutyid_eq',
      },
      {
        name: 'n_ormorgsectorid_eq',
      },
    ]
  }

}