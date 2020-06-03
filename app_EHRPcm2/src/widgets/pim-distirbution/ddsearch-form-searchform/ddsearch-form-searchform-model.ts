/**
 * DDSearchForm 部件模型
 *
 * @export
 * @class DDSearchFormModel
 */
export default class DDSearchFormModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof DDSearchFormModel
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
        name: 'n_ormpostname_like',
        prop: 'ormpostname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_ormdutyname_like',
        prop: 'ormdutyname',
        dataType: 'PICKUPTEXT',
      },
    ]
  }

}