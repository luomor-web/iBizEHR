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
        dataType: 'INHERIT',
      },
      {
        name: 'n_pimpersonname_like',
        prop: 'pimpersonname',
        dataType: 'INHERIT',
      },
      {
        name: 'n_zz_like',
        prop: 'zz',
        dataType: 'INHERIT',
      },
      {
        name: 'n_ormorgname_like',
        prop: 'ormorgname',
        dataType: 'PICKUPTEXT',
      },
    ]
  }

}