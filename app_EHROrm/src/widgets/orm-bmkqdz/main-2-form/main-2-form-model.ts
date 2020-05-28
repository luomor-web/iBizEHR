/**
 * Main_2 部件模型
 *
 * @export
 * @class Main_2Model
 */
export default class Main_2Model {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof Main_2Model
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
        name: 'srfupdatedate',
        prop: 'updatedate',
        dataType: 'DATE',
      },
      {
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'ormbmkqdzid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'ormbmkqdzname',
        dataType: 'TEXT',
      },
      {
        name: 'srftempmode',
      },
      {
        name: 'srfuf',
      },
      {
        name: 'srfdeid',
      },
      {
        name: 'srfsourcekey',
      },
      {
        name: 'ormbmkqdzname',
        prop: 'ormbmkqdzname',
        dataType: 'TEXT',
      },
      {
        name: 'ormorgsectorid',
        prop: 'ormorgsectorid',
        dataType: 'PICKUP',
      },
      {
        name: 'ormorgsectorname',
        prop: 'ormorgsectorname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'ormorgdzid',
        prop: 'ormorgdzid',
        dataType: 'TEXT',
      },
      {
        name: 'ormbmkqdzid',
        prop: 'ormbmkqdzid',
        dataType: 'GUID',
      },
      {
        name: 'ormbmkqdz',
        prop: 'ormbmkqdzid',
        dataType: 'FONTKEY',
      },
    ]
  }

}