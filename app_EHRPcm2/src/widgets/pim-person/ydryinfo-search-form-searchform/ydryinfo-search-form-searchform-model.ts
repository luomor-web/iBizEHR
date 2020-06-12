/**
 * YDRYInfoSearchForm 部件模型
 *
 * @export
 * @class YDRYInfoSearchFormModel
 */
export default class YDRYInfoSearchFormModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof YDRYInfoSearchFormModel
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
        name: 'n_ygzt_eq',
        prop: 'ygzt',
        dataType: 'SSCODELIST',
      },
    ]
  }

}