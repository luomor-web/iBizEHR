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
        name: 'n_zslx_eq',
        prop: 'zslx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_zsmc_like',
        prop: 'zsmc',
        dataType: 'TEXT',
      },
      {
        name: 'n_zgzsbh_like',
        prop: 'zgzsbh',
        dataType: 'TEXT',
      },
      {
        name: 'n_bcardnumber_like',
        prop: 'bcardnumber',
        dataType: 'TEXT',
      },
    ]
  }

}